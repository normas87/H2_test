package com.norbert.maselko.intive_backend.organization;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class OrganizationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "BAD_REQUEST --> name cannot be empty")
    @NotBlank(message = "BAD_REQUEST --> name should not contain whitespace")
    @Size(min = 2, max = 20, message = "BAD_REQUEST --> name should have atleast 2 characters and max 20 characters")
    private String name;

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

    @Override
    public String toString() {
        return "OrganizationModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
