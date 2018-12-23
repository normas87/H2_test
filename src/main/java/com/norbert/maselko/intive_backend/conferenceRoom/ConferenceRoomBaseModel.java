package com.norbert.maselko.intive_backend.conferenceRoom;

import javax.persistence.*;

@Entity
public class ConferenceRoomBaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String roomName;
    private int floor;
    private boolean available;
    private int numberOfSeats;
    private int numberOfStandingPlaces;
    private int numberOfHangingPlaces;
    private boolean availablePhone;

    public ConferenceRoomBaseModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfStandingPlaces() {
        return numberOfStandingPlaces;
    }

    public void setNumberOfStandingPlaces(int numberOfStandingPlaces) {
        this.numberOfStandingPlaces = numberOfStandingPlaces;
    }

    public int getNumberOfHangingPlaces() {
        return numberOfHangingPlaces;
    }

    public void setNumberOfHangingPlaces(int numberOfHangingPlaces) {
        this.numberOfHangingPlaces = numberOfHangingPlaces;
    }

    public boolean isAvailablePhone() {
        return availablePhone;
    }

    public void setAvailablePhone(boolean availablePhone) {
        this.availablePhone = availablePhone;
    }

    @Override
    public String toString() {
        return "ConferenceRoomBaseModel{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", floor=" + floor +
                ", available=" + available +
                ", numberOfSeats=" + numberOfSeats +
                ", numberOfStandingPlaces=" + numberOfStandingPlaces +
                ", numberOfHangingPlaces=" + numberOfHangingPlaces +
                ", availablePhone=" + availablePhone +
                '}';
    }
}

