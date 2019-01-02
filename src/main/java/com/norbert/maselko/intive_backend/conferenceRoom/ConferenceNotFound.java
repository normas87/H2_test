package com.norbert.maselko.intive_backend.conferenceRoom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ConferenceNotFound extends RuntimeException {
    ConferenceNotFound(String message) {
        super(message);
    }
}

