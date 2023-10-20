package com.api.hotelmanager.modules.hotel.service;

import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.api.hotelmanager.modules.hotel.dto.HotelRequest;
import com.api.hotelmanager.modules.hotel.dto.HotelResponse;
import com.api.hotelmanager.modules.hotel.entity.Hotel;
import com.api.hotelmanager.modules.hotel.repository.IHotelRepository;

import jakarta.persistence.EntityNotFoundException;

public class HotelServiceImpl implements  IHotelService{
	
	private final IHotelRepository hotelRepository;
	private final ModelMapper mapper;

	public HotelServiceImpl(IHotelRepository hotelRepository, ModelMapper mapper){
		this.hotelRepository = hotelRepository;
		this.mapper = mapper;
	}

	@Override
	public Hotel save(HotelRequest hotelRequest) {
		return hotelRepository.save(mapper.map(hotelRequest, Hotel.class));
	}

	@Override
	public Page<HotelResponse> findAll(Pageable pageable) {
		Page<Hotel> hotelPage = hotelRepository.findAll(pageable);
		Page<HotelResponse> hotelResponsePage = hotelPage.map(new Function<Hotel,HotelResponse>() {

			@Override
			public HotelResponse apply(Hotel hotel){
				return new ModelMapper().map(hotel,HotelResponse.class);
			}
		});
		return hotelResponsePage;
	}

	@Override
	public HotelResponse findById(Long id) {
		return mapper.map(hotelRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Hotel not found")), HotelResponse.class);
	}

	@Override
	public void delete(Long id) {
		hotelRepository.delete(id);
	}
}
