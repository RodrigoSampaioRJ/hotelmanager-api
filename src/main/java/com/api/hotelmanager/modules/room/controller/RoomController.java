package com.api.hotelmanager.modules.room.controller;

import java.net.URI;
import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.api.hotelmanager.modules.room.dto.RoomRequest;
import com.api.hotelmanager.modules.room.dto.RoomResponse;
import com.api.hotelmanager.modules.room.entity.Room;
import com.api.hotelmanager.modules.room.service.IRoomService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/room")
public class RoomController {

	private final IRoomService roomService;

	public RoomController(IRoomService roomServiceService) {
		this.roomService = roomServiceService;
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<RoomResponse> getRoom(@PathVariable Long id){
		RoomResponse roomResponse = roomService.findById(id);
		return ResponseEntity.ok(roomResponse);
	}
	
	@PostMapping
	public ResponseEntity<Room> createRoom(
			@RequestBody
			@Valid
			RoomRequest roomRequest,
			UriComponentsBuilder uriComponentsBuilder) {
		
		Room room = roomService.save(roomRequest);
		
		URI uri = uriComponentsBuilder
				.path("/api/room/{id}")
				.buildAndExpand(room.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(room);
	}

	@GetMapping(path ="/isavailable/{id}")
	public ResponseEntity<Boolean> isAvailable(@PathVariable Long id,@RequestParam Instant checkin,@RequestParam Instant checkout) {
		Boolean available = roomService.isAvailable(id,checkin,checkout);

		return ResponseEntity.ok(available);
	}
}
