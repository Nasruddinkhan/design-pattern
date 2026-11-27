package com.mypractice.oops.matchmaking;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

enum Region { NA, EU, ASIA, SA, AFRICA }

enum GameMode { SOLO, DUO, SQUAD }

enum PlayerStatus { ONLINE, QUEUED, MATCHED, IN_GAME, DISCONNECTED }

class Player {
    String id;
    String displayName;
    int mmr; // Match-making rating
    Region region;
    int pingMs;
    PlayerStatus status;
    PlayerStatistics stats = new PlayerStatistics();
    Party party; // nullable

    public Player(String id, String displayName, int mmr, Region region, int pingMs) {
        this.id = id;
        this.displayName = displayName;
        this.mmr = mmr;
        this.region = region;
        this.pingMs = pingMs;
        this.status = PlayerStatus.ONLINE;
    }

    void enqueue(GameMode mode, MatchmakingService service) {
        this.status = PlayerStatus.QUEUED;
        service.addToQueue(party != null ? party : new Party(List.of(this), mode, region), mode);
    }

    void dequeue(MatchmakingService service) {
        this.status = PlayerStatus.ONLINE;
        service.removeFromQueue(party != null ? party : new Party(List.of(this), null, null));
    }
}

class PlayerStatistics {
    long totalMatches;
    long wins;
    double averageDamage;

    void updateFromGame(GameResult result, Player player) {
        totalMatches++;
        if (result.placement.get(player) == 1) wins++;
        averageDamage = (averageDamage * (totalMatches - 1) + result.damage.getOrDefault(player, 0L)) / totalMatches;
    }
}

class Party {
    String id = UUID.randomUUID().toString();
    List<Player> members;
    GameMode preferredMode;
    Region preferredRegion;

    Party(List<Player> members, GameMode mode, Region region) {
        this.members = members;
        this.preferredMode = mode;
        this.preferredRegion = region;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Party party = (Party) obj;
        return Objects.equals(id, party.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

// ───────── matchmaking.engine ─────────

class MatchRequest {
    Party party;
    long queuedAtEpochMs;
    GameMode mode;
    Region region;

    MatchRequest(Party party, long time, GameMode mode, Region region) {
        this.party = party;
        this.queuedAtEpochMs = time;
        this.mode = mode;
        this.region = region;
    }
}

interface MatchmakingStrategy {
    List<Match> matchCandidates(List<MatchRequest> queue);
}

class RankAndLatencyStrategy implements MatchmakingStrategy {
    int mmrTolerance = 200;
    int maxPingMs = 150;
    int timeoutSecHard = 120;

    public List<Match> matchCandidates(List<MatchRequest> queue) {
        List<Match> matches = new ArrayList<>();
        List<MatchRequest> toRemove = new ArrayList<>();

        for (int i = 0; i < queue.size(); i++) {
            MatchRequest r1 = queue.get(i);
            List<Player> combined = new ArrayList<>(r1.party.members);

            for (int j = i + 1; j < queue.size(); j++) {
                MatchRequest r2 = queue.get(j);
                if (r1.mode != r2.mode || r1.region != r2.region) continue;
                if (!canMerge(r1.party.members, r2.party.members)) continue;
                combined.addAll(r2.party.members);

                if (combined.size() == expectedSize(r1.mode)) {
                    Match match = new Match(UUID.randomUUID().toString(), r1.mode, r1.region, combined);
                    matches.add(match);
                    toRemove.add(r1);
                    toRemove.add(r2);
                    break;
                }
            }
        }

        queue.removeAll(toRemove);
        return matches;
    }

    private boolean canMerge(List<Player> a, List<Player> b) {
        for (Player p : a) {
            for (Player q : b) {
                if (Math.abs(p.mmr - q.mmr) > mmrTolerance || p.pingMs > maxPingMs || q.pingMs > maxPingMs) {
                    return false;
                }
            }
        }
        return true;
    }

    private int expectedSize(GameMode mode) {
        return switch (mode) {
            case SOLO -> 2;
            case DUO -> 4;
            case SQUAD -> 8;
        };
    }
}

class MatchmakingService {
    List<MatchRequest> queue = new CopyOnWriteArrayList<>();
    MatchmakingStrategy strategy = new RankAndLatencyStrategy();
    List<MatchObserver> observers = new CopyOnWriteArrayList<>();

    void addToQueue(Party p, GameMode mode) {
        queue.add(new MatchRequest(p, System.currentTimeMillis(), mode, p.preferredRegion));
    }

    void removeFromQueue(Party p) {
        queue.removeIf(req -> req.party.equals(p));
    }

    void tick() {
        List<Match> ready = strategy.matchCandidates(queue);
        ready.forEach(this::notifyFound);
    }

    private void notifyFound(Match m) {
        observers.forEach(o -> o.onMatchFound(m));
    }
}

interface MatchObserver {
    void onMatchFound(Match match);
}

// ───────── game.session ─────────

enum MatchStatus { FORMING, COUNTDOWN, IN_PROGRESS, FINISHED }

class Match {
    String id;
    GameMode mode;
    Region region;
    List<Player> players;
    MatchStatus status = MatchStatus.FORMING;
    long createdEpoch;

    public Match(String id, GameMode mode, Region region, List<Player> players) {
        this.id = id;
        this.mode = mode;
        this.region = region;
        this.players = players;
        this.createdEpoch = System.currentTimeMillis();
    }

    void start() {
        status = MatchStatus.COUNTDOWN;
    }

    void completeGame(GameResult result) {
        status = MatchStatus.FINISHED;
        for (Player p : players) {
            p.stats.updateFromGame(result, p);
        }
    }
}

class GameResult {
    Map<Player, Integer> placement;
    Map<Player, Long> damage;

    public GameResult(Map<Player, Integer> placement, Map<Player, Long> damage) {
        this.placement = placement;
        this.damage = damage;
    }
}
public class MatchmakingTest {
    public static void main(String[] args) {
        MatchmakingService service = new MatchmakingService();

        Player p1 = new Player("p1", "PlayerOne", 1500, Region.NA, 50);
        Player p2 = new Player("p2", "PlayerTwo", 1550, Region.NA, 45);

        Party party1 = new Party(List.of(p1), GameMode.SOLO, Region.NA);
        Party party2 = new Party(List.of(p2), GameMode.SOLO, Region.NA);

        service.addToQueue(party1, GameMode.SOLO);
        service.addToQueue(party2, GameMode.SOLO);

        service.observers.add(match -> {
            System.out.println("Match Found:");
            for (Player player : match.players) {
                System.out.println(" - " + player.displayName);
            }
        });

        service.tick(); // triggers matchmaking
    }
}
