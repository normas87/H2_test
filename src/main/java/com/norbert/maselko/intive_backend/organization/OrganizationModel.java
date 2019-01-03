package com.norbert.maselko.intive_backend.organization;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.norbert.maselko.intive_backend.conferenceRoom.ConferenceRoomModel;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
public class OrganizationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "BAD_REQUEST --> name cannot be empty")
    @NotBlank(message = "BAD_REQUEST --> name should not contain whitespace")
    @Size(min = 2, max = 20, message = "BAD_REQUEST --> name should have atleast 2 characters and max 20 characters")
    private String name;

    @OneToMany
    private List<ConferenceRoomModel> conferenceRoomModels;

    @Future
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate startConference;
    @Future
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate stopConference;
    public OrganizationModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ConferenceRoomModel> getConferenceRoomModels() {
        return conferenceRoomModels;
    }

    public void setConferenceRoomModels(List<ConferenceRoomModel> conferenceRoomModels) {
        this.conferenceRoomModels = conferenceRoomModels;
    }

    public LocalDate getStartConference() {
        return startConference;
    }

    public void setStartConference(LocalDate startConference) {
        this.startConference = startConference;
    }

    public LocalDate getStopConference() {
        return stopConference;
    }

    public void setStopConference(LocalDate stopConference) {
        this.stopConference = stopConference;
    }

    @Override
    public String toString() {
        return "OrganizationModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", conferenceRoomModels=" + conferenceRoomModels +
                ", startConference=" + startConference +
                ", stopConference=" + stopConference +
                '}';
    }
}

