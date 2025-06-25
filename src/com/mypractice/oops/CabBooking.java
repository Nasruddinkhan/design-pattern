package com.mypractice.oops;
abstract class User {
    protected String userId;
    protected String name;
    protected String phone;

    public User(String userId, String name, String phone) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
    }
}
 class Rider extends User {
    public Rider(String userId, String name, String phone) {
        super(userId, name, phone);
    }

    public Ride requestRide(Location source, Location destination, RideType type) {
        return new Ride(this, source, destination, type);
    }
}
 class Driver extends User {
    private Vehicle vehicle;
    private boolean available = true;

    public Driver(String userId, String name, String phone, Vehicle vehicle) {
        super(userId, name, phone);
        this.vehicle = vehicle;
    }

    public void acceptRide(Ride ride) {
        ride.setDriver(this);
        this.available = false;
    }
}

 class Vehicle {
    private String number;
    private String model;
    private RideType type;

    public Vehicle(String number, String model, RideType type) {
        this.number = number;
        this.model = model;
        this.type = type;
    }
}
 class Location {
    private double latitude;
    private double longitude;

     public Location(double latitude, double longitude) {
         this.latitude = latitude;
         this.longitude = longitude;
     }

     public double calculateDistance(Location other) {
        // Dummy logic for distance
        return Math.sqrt(Math.pow(latitude - other.latitude, 2) + Math.pow(longitude - other.longitude, 2));
    }
}

 class Ride {
    private Rider rider;
    private Driver driver;
    private Location source;
    private Location destination;
    private RideType rideType;
    private double fare;

    public Ride(Rider rider, Location source, Location destination, RideType rideType) {
        this.rider = rider;
        this.source = source;
        this.destination = destination;
        this.rideType = rideType;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void calculateFare() {
        PricingStrategy pricingStrategy = rideType.getPricingStrategy();
        this.fare = pricingStrategy.calculateFare(source.calculateDistance(destination));
    }

    public double getFare() {
        return fare;
    }
}
 interface PricingStrategy {
    double calculateFare(double distanceInKm);
}

 class NormalPricing implements PricingStrategy {
    public double calculateFare(double distanceInKm) {
        return 10 * distanceInKm;
    }
}

 class PremiumPricing implements PricingStrategy {
    public double calculateFare(double distanceInKm) {
        return 15 * distanceInKm + 50; // base fare
    }
}
 enum RideType {
    NORMAL(new NormalPricing()),
    PREMIUM(new PremiumPricing());

    private final PricingStrategy strategy;

    RideType(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public PricingStrategy getPricingStrategy() {
        return strategy;
    }
}



public class CabBooking {
    public static void main(String[] args) {
        Rider nasruddin = new Rider("R01", "Nasruddin", "9999");
        Location source = new Location(10.0, 20.0);
        Location dest = new Location(12.0, 25.0);

        Ride ride = nasruddin.requestRide(source, dest, RideType.PREMIUM);

        Driver driver = new Driver("D01", "Ahmed", "8888", new Vehicle("MH12AB1234", "Swift", RideType.PREMIUM));
        driver.acceptRide(ride);

        ride.calculateFare();
        System.out.println("Fare: ₹" + ride.getFare());
    }
}
