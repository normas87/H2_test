package com.norbert.maselko.intive_backend.conferenceRoom;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConferenceRoomRepository extends CrudRepository<ConferenceRoomModel, Long> {
  List<ConferenceRoomModel>findAll();
  List<ConferenceRoomModel>findByRoomNameContainingIgnoreCase(String roomName);
}