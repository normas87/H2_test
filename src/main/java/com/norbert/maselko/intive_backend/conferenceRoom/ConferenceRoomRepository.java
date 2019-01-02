package com.norbert.maselko.intive_backend.conferenceRoom;


import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ConferenceRoomRepository extends CrudRepository<ConferenceRoomBaseModel, Long> {
  List<ConferenceRoomBaseModel>findAll();
  List<ConferenceRoomBaseModel>findByRoomName(String roomName);
}