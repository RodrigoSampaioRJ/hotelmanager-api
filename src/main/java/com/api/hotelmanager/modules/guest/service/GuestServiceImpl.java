package com.api.hotelmanager.modules.guest.service;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.hotelmanager.modules.guest.dto.GuestRequest;
import com.api.hotelmanager.modules.guest.dto.GuestResponse;
import com.api.hotelmanager.modules.guest.entity.Guest;
import com.api.hotelmanager.modules.guest.mapper.GuestMapper;
import com.api.hotelmanager.modules.guest.repository.IGuestRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class GuestServiceImpl implements  IGuestService{

	@Autowired
	private IGuestRepository guestRepository;
	@Autowired
	private GuestMapper mapper;

	// public GuestServiceImpl(IGuestRepository guestRepository, ModelMapper mapper){
	// 	this.guestRepository = guestRepository;
	// 	this.mapper = mapper;
	// }

	@Override
	public Guest save(GuestRequest guestRequest) {
		System.out.println(guestRequest.name());
		Guest guest  = mapper.guestRequestToGuest(guestRequest);
		System.out.println(guest.getName());
		guestRepository.save(guest);
		return guest;
	}

	@Override
	public Page<GuestResponse> findAll(Pageable pageable) {
		Page<Guest> guestPage = guestRepository.findAll(pageable);

		Page<GuestResponse> guestResponsePage = guestPage.map(new Function<Guest, GuestResponse>(){
			@Override
			public GuestResponse apply(Guest guest){
				return mapper.guestToGuestResponse(guest);
			}
		});
		return guestResponsePage;
	}

	@Override
	public GuestResponse findById(Long id) {
		Guest guest = guestRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Guest not found"));
		return mapper.guestToGuestResponse(guest);
	}

	@Override
	public void delete(Long id) {
		guestRepository.delete(id);
	}
}
