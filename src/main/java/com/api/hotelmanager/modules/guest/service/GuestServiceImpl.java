package com.api.hotelmanager.modules.guest.service;

import com.api.hotelmanager.modules.guest.dto.GuestRequest;
import com.api.hotelmanager.modules.guest.dto.GuestResponse;
import com.api.hotelmanager.modules.guest.entity.Guest;
import com.api.hotelmanager.modules.guest.mapper.GuestMapper;
import com.api.hotelmanager.modules.guest.repository.IGuestRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class GuestServiceImpl implements  IGuestService{

	private final IGuestRepository guestRepository;
	private final GuestMapper mapper;

	public GuestServiceImpl(IGuestRepository guestRepository, GuestMapper mapper){
		this.guestRepository = guestRepository;
		this.mapper = mapper;
	}

	@Override
	public Guest save(GuestRequest guestRequest) {
		return guestRepository.save(mapper.mapToGuest(guestRequest));
	}

	@Override
	public Page<GuestResponse> findAll(Pageable pageable) {
		Page<Guest> guestPage = guestRepository.findAll(pageable);
		return guestPage.map(mapper::mapToGuestResponse);
	}

	@Override
	public GuestResponse findById(Long id) {
		return mapper.mapToGuestResponse(guestRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Guest not found")));
	}

	@Override
	public void delete(Long id) {
		guestRepository.delete(id);
	}
}
