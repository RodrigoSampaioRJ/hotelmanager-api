package com.api.hotelmanager.modules.room.controller;

import com.api.hotelmanager.modules.room.dto.RoomRequest;
import com.api.hotelmanager.modules.room.dto.RoomResponse;
import com.api.hotelmanager.modules.room.entity.Room;
import com.api.hotelmanager.modules.room.service.IRoomService;
import com.api.hotelmanager.modules.room.service.RoomServiceImpl;
import com.api.hotelmanager.modules.user.service.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

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
}
