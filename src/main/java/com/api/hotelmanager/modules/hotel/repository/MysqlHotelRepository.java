package com.api.hotelmanager.modules.hotel.repository;

import com.api.hotelmanager.modules.hotel.entity.Hotel;
import com.api.hotelmanager.modules.room.entity.Room;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Primary
public class MysqlHotelRepository implements IHotelRepository{

    private final SpringDataMysqlHotelRepository hotelRepository;

    public MysqlHotelRepository(SpringDataMysqlHotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Optional<Hotel> findById(Long id) {
        return this.hotelRepository.findById(id);
    }

    @Override
    public Page<Hotel> findAll(Pageable pageable) {
        return this.hotelRepository.findAll(pageable);
    }

    @Override
    public Hotel save(Hotel hotel) {
        return this.hotelRepository.save(hotel);
    }

    @Override
    public void delete(Long id) {
        this.hotelRepository.deleteById(id);
    }
}
