package com.norbert.maselko.intive_backend.conferenceRoom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConferenceRoomService  {
    private ConferenceRoomRepository conferenceRoomRepository;

    @Autowired
    public ConferenceRoomService(ConferenceRoomRepository conferenceRoomRepository) {
        this.conferenceRoomRepository = conferenceRoomRepository;
    }


    public List<ConferenceRoomModel> getAllConferenceRooms() {
        List<ConferenceRoomModel> conferenceRooms = new ArrayList<ConferenceRoomModel>();
        conferenceRoomRepository.findAll().forEach(conferenceRoomModel -> conferenceRooms.add(conferenceRoomModel));
        return conferenceRooms;
    }

    public ConferenceRoomModel getConferenceRoomById(long id) {
        ConferenceRoomModel conferenceRoomModel = conferenceRoomRepository.findById(id).orElse(null);
        if (conferenceRoomModel == null) {
            throw new ConferenceErrorMessage("Nie odnaleziono sali konferencyjnej o id: " + id);
        } else {
            return conferenceRoomRepository.findById(id).get();
        }
    }

    public void delete(long id) {
        conferenceRoomRepository.deleteById(id);
    }





    public boolean save(ConferenceRoomModel conferenceRoomModel) {
        List<ConferenceRoomModel> list = conferenceRoomRepository.findByRoomNameContainingIgnoreCase(conferenceRoomModel.getRoomName());
        if (list.size() > 0) {
            throw new ConferenceErrorMessage("Podana nazwa sali konferencyjnej już istnieje");
        } else {
            conferenceRoomRepository.save(conferenceRoomModel);
            return true;
        }
    }
}