package com.api.hotelmanager.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.hotelmanager.dtos.HotelRequest;
import com.api.hotelmanager.dtos.HotelResponse;
import com.api.hotelmanager.entities.Hotel;
import com.api.hotelmanager.repositories.HotelRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HotelService {
	
	private final HotelRepository hotelRepository;
	
	public HotelResponse getHotel(Long id) {
		HotelResponse hotelResponse = mapTohotelResponse(hotelRepository
				.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Hotel not found")));
		return hotelResponse;
	}
	
	public Page<HotelResponse> getAll(Pageable page){
		
		Page<Hotel> hotelPage = hotelRepository.findAll(page);
		Page<HotelResponse> hotelResponsePage = hotelPage.map(this::mapTohotelResponse);
		return hotelResponsePage;
		
	}
	
	public Hotel createHotel(HotelRequest hotelRequest) {
		Hotel hotel = hotelRepository.save(mapToHotel(hotelRequest));
		return hotel;
	}
	
	public Hotel mapToHotel(HotelRequest hotelRequest) {
		Hotel hotel = Hotel.builder()
				.name(hotelRequest.name())
				.address(hotelRequest.address())
				.stars(hotelRequest.stars())
				.rooms(hotelRequest.rooms())
				.build();
		return hotel;
	}
	
	public HotelResponse mapTohotelResponse(Hotel hotel) {
		HotelResponse hotelResponse = HotelResponse.builder()
				.name(hotel.getName())
				.address(hotel.getAddress())
				.stars(hotel.getStars())
				.rooms(hotel.getRooms())
				.id(hotel.getId())
				.build();
		return hotelResponse;
	}

}
