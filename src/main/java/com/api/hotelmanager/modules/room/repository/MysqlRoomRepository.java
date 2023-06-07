package com.api.hotelmanager.modules.room.repository;

import com.api.hotelmanager.modules.room.entity.Room;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Primary
public class MysqlRoomRepository implements IRoomRepository{

    private final SpringDataMysqlRoomRepository roomRepository;

    public MysqlRoomRepository(SpringDataMysqlRoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    @Override
    public Optional<Room> findById(Long id) {
        return this.roomRepository.findById(id);
    }

    @Override
    public Page<Room> findAll(Pageable pageable) {
        return this.roomRepository.findAll(pageable);
    }

    @Override
    public Room save(Room room) {
        return this.roomRepository.save(room);
    }

    @Override
    public void delete(Long id) {
        this.roomRepository.deleteById(id);
    }
}
