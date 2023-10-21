package com.api.hotelmanager.modules.hotel.service;

import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.api.hotelmanager.modules.hotel.dto.HotelRequest;
import com.api.hotelmanager.modules.hotel.dto.HotelResponse;
import com.api.hotelmanager.modules.hotel.entity.Hotel;
import com.api.hotelmanager.modules.hotel.mapper.HotelMapper;
import com.api.hotelmanager.modules.hotel.repository.IHotelRepository;

import jakarta.persistence.EntityNotFoundException;

public class HotelServiceImpl implements  IHotelService{
	
	private final IHotelRepository hotelRepository;
	private final HotelMapper mapper;

	public HotelServiceImpl(IHotelRepository hotelRepository, HotelMapper mapper){
		this.hotelRepository = hotelRepository;
		this.mapper = mapper;
	}

	@Override
	public Hotel save(HotelRequest hotelRequest) {
		return hotelRepository.save(mapper.hotelRequestToHotel(hotelRequest));
	}

	@Override
	public Page<HotelResponse> findAll(Pageable pageable) {
		Page<Hotel> hotelPage = hotelRepository.findAll(pageable);
		Page<HotelResponse> hotelResponsePage = hotelPage.map(new Function<Hotel,HotelResponse>() {

			@Override
			public HotelResponse apply(Hotel hotel){
				return mapper.hotelTHotelResponse(hotel);
			}
		});
		return hotelResponsePage;
	}

	@Override
	public HotelResponse findById(Long id) {

		HotelResponse hotelResponse = mapper.hotelTHotelResponse(hotelRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Hotel not found")));

		return hotelResponse;
	}

	@Override
	public void delete(Long id) {
		hotelRepository.delete(id);
	}
}
