package com.norbert.maselko.intive_backend.organization;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrganizationRepository extends CrudRepository<OrganizationModel, Long> {
    List<OrganizationModel> findAll();
    List<OrganizationModel> findByNameContainingIgnoreCase(String name);
}



