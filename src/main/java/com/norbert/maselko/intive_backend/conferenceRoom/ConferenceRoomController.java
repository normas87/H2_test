package com.norbert.maselko.intive_backend.conferenceRoom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ConferenceRoomController {

    @Autowired
    ConferenceRoomService conferenceRoomService;

    @GetMapping("/rooms")
    private List<ConferenceRoomModel> getAll() {
        return conferenceRoomService.getAllConferenceRooms();
    }

    @GetMapping("/rooms/{id}")
    private ConferenceRoomModel getRoom(@PathVariable("id") long id) {
        return conferenceRoomService.getConferenceRoomById(id);
    }

    @DeleteMapping("/rooms/{id}")
    private void deleteRoom(@PathVariable("id") long id) {
        conferenceRoomService.delete(id);
    }

    @PostMapping("/rooms")
    private long addRoom(@Valid @RequestBody ConferenceRoomModel conferenceRoomModel) {
            conferenceRoomService.save(conferenceRoomModel);
        return conferenceRoomModel.getId();
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