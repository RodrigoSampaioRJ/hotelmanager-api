package com.api.hotelmanager.modules.hotel.service;

import com.api.hotelmanager.modules.hotel.dto.HotelRequest;
import com.api.hotelmanager.modules.hotel.dto.HotelResponse;
import com.api.hotelmanager.modules.hotel.entity.Hotel;
import com.api.hotelmanager.modules.hotel.mapper.HotelMapper;
import com.api.hotelmanager.modules.hotel.repository.IHotelRepository;
import com.api.hotelmanager.modules.hotel.repository.MysqlHotelRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public class HotelServiceImpl implements  IHotelService{
	
	private final IHotelRepository hotelRepository;
	private final HotelMapper mapper;

	public HotelServiceImpl(IHotelRepository hotelRepository, HotelMapper mapper){
		this.hotelRepository = hotelRepository;
		this.mapper = mapper;
	}

	@Override
	public Hotel save(HotelRequest hotelRequest) {
		return hotelRepository.save(mapper.mapToHotel(hotelRequest));
	}

	@Override
	public Page<HotelResponse> findAll(Pageable pageable) {
		Page<Hotel> hotelPage = hotelRepository.findAll(pageable);
		return hotelPage.map(mapper::mapToHotelResponse);
	}

	@Override
	public HotelResponse findById(Long id) {
		return mapper.mapToHotelResponse(hotelRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Hotel not found")));
	}

	@Override
	public void delete(Long id) {
		hotelRepository.delete(id);
	}
}
