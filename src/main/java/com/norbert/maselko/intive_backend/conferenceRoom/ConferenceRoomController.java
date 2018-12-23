package com.norbert.maselko.intive_backend.conferenceRoom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConferenceRoomController {



    @Autowired
    ConferenceRoomService conferenceRoomService;


    @GetMapping("/rooms")
    private List<ConferenceRoomBaseModel> getAll() {
        return conferenceRoomService.getAllConferenceRooms();
    }

    @GetMapping("/rooms/{id}")
    private ConferenceRoomBaseModel getRoom(@PathVariable("id") long id) {
        return conferenceRoomService.getConferenceRoomById(id);
    }

    @DeleteMapping("/rooms/{id}")
    private void deletePerson(@PathVariable("id") long id) {
        conferenceRoomService.delete(id);
    }

    @PostMapping("/rooms")
    private long savePerson(@RequestBody ConferenceRoomBaseModel conferenceRoomBaseModel) {
        conferenceRoomService.saveOrUpdate(conferenceRoomBaseModel);
        return conferenceRoomBaseModel.getId();
    }
}