package com.mypractice.oops;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class User{
    private String id;
    private String email;
    private List<StorageItem> myFiles;

    public User(String id, String email){
        this.id = id;
        this.email = email;
    }
}
 class Permission {
    private User user;
    private AccessLevel level;

     public Permission(User user, AccessLevel accessLevel) {
         this.user = user;
         this.level = accessLevel;
     }

     public User getUser() {
         return user;
     }

     public AccessLevel getLevel() {
         return level;
     }
 }
class Version {
    private String versionId;
    private byte[] content;
    private LocalDate timestamp;
}
 enum AccessLevel {
    VIEW, EDIT, OWNER
}
 abstract class StorageItem {
    protected String id;
    protected String name;
    protected User owner;
    protected LocalDate createdAt;
    protected List<Permission> permissions = new ArrayList<>();

     public StorageItem(String name, User owner) {
         this.name = name;
         this.owner = owner;
     }

     public abstract long getSize();
    public abstract void delete();
    public abstract void restore();

    public void shareWith(User user, AccessLevel accessLevel) {
        permissions.add(new Permission(user, accessLevel));
    }
}

 class FileItem extends StorageItem {
    private long size;
    private String mimeType;
    private List<Version> versions = new ArrayList<>();

     public FileItem(String name, User owner) {
       super(name, owner);
     }

     public FileItem(String name, User nasr, int i, String contentType) {
         super(name, nasr);
         this.size = i;
         this.mimeType = contentType;
     }

     public long getSize() { return size; }

    public void delete() {
        TrashService.moveToTrash(this);
    }

    public void restore() {
        TrashService.restoreFromTrash(this);
    }
}

 class FolderItem extends StorageItem {
    private List<StorageItem> children = new ArrayList<>();

     public FolderItem(String name, User owner) {
        super(name, owner);
     }

     public void addItem(StorageItem item) {
        children.add(item);
    }

    public long getSize() {
        return children.stream().mapToLong(StorageItem::getSize).sum();
    }

    public void delete() {
        for (StorageItem item : children)
            item.delete();
    }

    public void restore() {
        for (StorageItem item : children)
            item.restore();
    }
}
class TrashService {
    private static Set<StorageItem> trashBin = new HashSet<>();

    public static void moveToTrash(StorageItem item) {
        trashBin.add(item);
        // Mark as "trashed" in metadata
    }

    public static void restoreFromTrash(StorageItem item) {
        trashBin.remove(item);
        // Restore metadata state
    }
}
interface AccessControlStrategy {
    boolean canAccess(User user, StorageItem item, AccessLevel required);
}

 class DefaultAccessControl implements AccessControlStrategy {
    public boolean canAccess(User user, StorageItem item, AccessLevel required) {
        return item.permissions.stream()
                .anyMatch(p -> p.getUser().equals(user) && p.getLevel().ordinal() >= required.ordinal());
    }
}
class StorageFactory {
    public static StorageItem create(String type, String name, User owner) {
        return switch (type) {
            case "file" -> new FileItem(name, owner);
            case "folder" -> new FolderItem(name, owner);
            default -> throw new IllegalArgumentException("Unknown type");
        };
    }
}
public class Storage {
    public static void main(String[] args) {

        User nasr = new User("U123", "nasr@example.com");

        FolderItem driveRoot = new FolderItem("Root", nasr);
        FileItem resume = new FileItem("Resume.pdf", nasr, 1024, "application/pdf");

        driveRoot.addItem(resume);
        resume.shareWith(new User("U999", "ayan@example.com"), AccessLevel.VIEW);

        resume.delete();
    }
}
