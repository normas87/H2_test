package com.norbert.maselko.intive_backend.conferenceRoom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return conferenceRoomRepository.findById(id).get();
    }

    public void saveOrUpdate(ConferenceRoomBaseModel conferenceRoomBaseModel) {
        conferenceRoomRepository.save(conferenceRoomBaseModel);
    }

    public void delete(long id) {
        conferenceRoomRepository.deleteById(id);
    }

}
