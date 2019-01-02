package com.norbert.maselko.intive_backend.conferenceRoom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConferenceRoomService {
    private ConferenceRoomRepository conferenceRoomRepository;

    @Autowired
    public ConferenceRoomService(ConferenceRoomRepository conferenceRoomRepository) {
        this.conferenceRoomRepository = conferenceRoomRepository;
    }


    public List<ConferenceRoomBaseModel> getAllConferenceRooms() {
        List<ConferenceRoomBaseModel> conferenceRooms = new ArrayList<ConferenceRoomBaseModel>();
        conferenceRoomRepository.findAll().forEach(conferenceRoomBaseModel -> conferenceRooms.add(conferenceRoomBaseModel));
        return conferenceRooms;
    }

    public ConferenceRoomBaseModel getConferenceRoomById(long id) {
        ConferenceRoomBaseModel conferenceRoomBaseModel = conferenceRoomRepository.findById(id).orElse(null);
        if (conferenceRoomBaseModel == null) {
            throw new ConferenceNotFound("Nie odnaleziono sali konferencyjnej o id: " + id);
        } else {
            return conferenceRoomRepository.findById(id).get();
        }






    }

    public void saveOrUpdate(ConferenceRoomBaseModel conferenceRoomBaseModel) {
        conferenceRoomRepository.save(conferenceRoomBaseModel);
    }

    public ConferenceRoomBaseModel getConferenceRoomByRoomName(String roomName) {
        ConferenceRoomBaseModel conferenceRoomBaseModel = conferenceRoomRepository.findByRoomName(roomName).orElse(null);
        if (conferenceRoomBaseModel == null) {
            conferenceRoomRepository.save(conferenceRoomBaseModel);
        } else {
            return throw new ConferenceRoomIsAlreadyExist("nazwa już istnieje");

        }



    public void delete(long id) {
        conferenceRoomRepository.deleteById(id);
    }

}
