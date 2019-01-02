package com.norbert.maselko.intive_backend.organization;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrganizationErrorMessage extends RuntimeException {
    OrganizationErrorMessage(String message) {
        super(message);
    }
}
