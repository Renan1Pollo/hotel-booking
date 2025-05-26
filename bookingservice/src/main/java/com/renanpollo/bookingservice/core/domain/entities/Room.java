package com.renanpollo.bookingservice.core.domain.entities;

public class Room {

    private Long id;
    private String name;
    private int level;
    private boolean inMaintenance;

    public Room() {}

    public Room(Long id, String name, int level, boolean inMaintenance) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.inMaintenance = inMaintenance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isInMaintenance() {
        return inMaintenance;
    }

    public void setInMaintenance(boolean inMaintenance) {
        this.inMaintenance = inMaintenance;
    }

    public boolean isAvailable() {
        return !isInMaintenance() && !hasGuest();
    }

    public boolean hasGuest() {
        return true;
    }
}
