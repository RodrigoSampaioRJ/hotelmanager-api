package com.api.hotelmanager.modules.room.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.api.hotelmanager.modules.room.dto.RoomRequest;
import com.api.hotelmanager.modules.room.dto.RoomResponse;
import com.api.hotelmanager.modules.room.entity.Room;
import com.api.hotelmanager.modules.room.service.RoomService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/room")
@RequiredArgsConstructor
public class RoomController {

	private final RoomService roomService;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<RoomResponse> getRoom(@PathVariable Long id){
		RoomResponse roomResponse = roomService.getRoom(id);
		return ResponseEntity.ok(roomResponse);
	}
	
	@PostMapping
	public ResponseEntity<Room> createRoom(
			@RequestBody
			@Valid
			RoomRequest roomRequest,
			UriComponentsBuilder uriComponentsBuilder) {
		
		Room room = roomService.createRoom(roomRequest);
		
		URI uri = uriComponentsBuilder
				.path("/api/room/{id}")
				.buildAndExpand(room.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(room);
	}
}
