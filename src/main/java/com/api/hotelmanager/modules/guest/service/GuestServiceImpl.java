package com.api.hotelmanager.modules.guest.service;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.hotelmanager.exceptions.EmailAlreadyInUseException;
import com.api.hotelmanager.exceptions.EntityNotFoundException;
import com.api.hotelmanager.modules.guest.dto.GuestRequest;
import com.api.hotelmanager.modules.guest.dto.GuestResponse;
import com.api.hotelmanager.modules.guest.entity.Guest;
import com.api.hotelmanager.modules.guest.mapper.GuestMapper;
import com.api.hotelmanager.modules.guest.repository.IGuestRepository;

@Service
public class GuestServiceImpl implements  IGuestService{

	@Autowired
	private IGuestRepository guestRepository;
	@Autowired
	private GuestMapper mapper;
	private final String guestNotFoundMessage = "Guest not found!";

	public GuestServiceImpl(IGuestRepository guestRepository, GuestMapper mapper){
		this.guestRepository = guestRepository;
		this.mapper = mapper;
	}

	@Override
	public Guest save(GuestRequest guestRequest) {
		Optional<Guest> guestOpt = guestRepository.findByEmail(guestRequest.email());

		if(guestOpt.isPresent()){
			throw new EmailAlreadyInUseException();
		}
		
		Guest guest  = mapper.guestRequestToGuest(guestRequest);
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
		Guest guest = guestRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(guestNotFoundMessage));
		return mapper.guestToGuestResponse(guest);
	}

	@Override
	public void delete(Long id) {
		guestRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(guestNotFoundMessage));
		guestRepository.delete(id);
	}

	@Override
	public GuestResponse update(Long id, GuestRequest guestRequest) {
		Guest guest = guestRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(guestNotFoundMessage));
		guest = mapper.guestRequestToGuest(guestRequest);
		guest.setId(id);
		guestRepository.save(guest);

		return mapper.guestToGuestResponse(guest);
	}
}
