package com.norbert.maselko.intive_backend.conferenceRoom;

import com.norbert.maselko.intive_backend.organization.OrganizationModel;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class ConferenceRoomModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roomId;

    @NotNull(message = "BAD_REQUEST --> name cannot be empty")
    @NotBlank(message = "BAD_REQUEST --> name should not contain whitespace")
    @Size(min = 2, max = 20, message = "BAD_REQUEST --> name should have atleast 2 characters and max 20 characters")
    private String roomName;
    @Min(value = 0, message = "BAD_REQUEST --> min value of floor is 0")
    @Max(value = 10, message = "BAD_REQUEST --> max value of floor is 10")
    private int floor;
    private boolean available;
    private int numberOfSeats;
    private int numberOfStandingPlaces;
    private int numberOfHangingPlaces;
    private boolean Phone;
    private boolean Projector;
    private boolean Interface;

    @ManyToOne
    private OrganizationModel organizationModels;

    public ConferenceRoomModel() {
    }

    public long getId() {
        return roomId;
    }

    public void setId(long id) {
        this.roomId = id;
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

    public boolean isPhone() {
        return Phone;
    }

    public void setPhone(boolean phone) {
        Phone = phone;
    }

    public boolean isProjector() {
        return Projector;
    }

    public void setProjector(boolean projector) {
        Projector = projector;
    }

    public boolean isInterface() {
        return Interface;
    }

    public void setInterface(boolean anInterface) {
        Interface = anInterface;
    }

    @Override
    public String toString() {
        return "ConferenceRoomModel{" +
                "id=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", floor=" + floor +
                ", available=" + available +
                ", numberOfSeats=" + numberOfSeats +
                ", numberOfStandingPlaces=" + numberOfStandingPlaces +
                ", numberOfHangingPlaces=" + numberOfHangingPlaces +
                ", Phone=" + Phone +
                ", Projector=" + Projector +
                ", Interface=" + Interface +
                '}';
    }
}


