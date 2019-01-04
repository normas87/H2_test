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

    public void updateOrganization(long id, OrganizationModel organizationModel) {
        List<OrganizationModel> list = organizationRepository.findByOrganizationId(organizationModel.getId());
        if (list.size() > 0) {
            throw new OrganizationErrorMessage("Nie ma organizacji o id: " + id);
        } else {
            organizationModel.setId(id);
            organizationRepository.save(organizationModel);
        }
    }


    public boolean save(OrganizationModel organizationModel) {
        List<OrganizationModel> list = organizationRepository.findByNameContainingIgnoreCase(organizationModel.getName());
        if (list.size() > 0) {
            throw new OrganizationErrorMessage("Podana nazwa organizacji już istnieje");
        } else {
            organizationRepository.save(organizationModel);
            return true;
        }
    }
}