package com.norbert.maselko.intive_backend.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizationService {

    private OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public List<OrganizationModel> getAllOrganizations() {
        List<OrganizationModel> organizations = new ArrayList<>();
        organizationRepository.findAll().forEach(organizationModel -> organizations.add(organizationModel));
        return organizations;
    }


    public OrganizationModel getOrganizationById(long id) {
        OrganizationModel organizationModel = organizationRepository.findById(id).orElse(null);
        if (organizationModel == null) {
            throw new OrganizationErrorMessage("Nie odnalezionio organizacji o id: " + id);
        } else {
            return organizationRepository.findById(id).get();
        }
    }

    public void delete(long id) {
        organizationRepository.deleteById(id);
    }

    public boolean save(OrganizationModel organizationModel) {
        List<OrganizationModel> list = organizationRepository.findByNameContainingIgnoreCase(organizationModel.getName());
        if (list.size() > 0) {
            throw new OrganizationErrorMessage("Nazwa sali konferencyjnej jest już zajęta");
        } else {
            organizationRepository.save(organizationModel);
            return true;
        }
    }
}
