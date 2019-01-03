package com.norbert.maselko.intive_backend.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrganizationController {

    @Autowired
    OrganizationService organizationService;

    @GetMapping("/organizations")
    private List<OrganizationModel> getAll() {
        return organizationService.getAllOrganizations();
    }

    @GetMapping("/organizations/{id}")
    private OrganizationModel getOrganization(@PathVariable("id") long id) {
        return organizationService.getOrganizationById(id);
    }

    @DeleteMapping("/organizations/{id}")
    private void deleteOrganization(@PathVariable("id") long id) {
        organizationService.delete(id);
    }

    @PostMapping("/organizations")
    private long addOrganization(@Valid @RequestBody OrganizationModel organizationModel) {
        organizationService.save(organizationModel);
        return organizationModel.getId();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ex.getBindingResult()
                .getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
    }


}
