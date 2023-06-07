package com.api.hotelmanager.infra.configuration.mysql;

import com.api.hotelmanager.modules.guest.repository.SpringDataMysqlGuestRepository;
import com.api.hotelmanager.modules.hotel.repository.SpringDataMysqlHotelRepository;
import com.api.hotelmanager.modules.profile.repository.SpringDataMysqlProfileRepository;
import com.api.hotelmanager.modules.reservation.repository.SpringDataMysqlReservationRepository;
import com.api.hotelmanager.modules.room.repository.SpringDataMysqlRoomRepository;
import com.api.hotelmanager.modules.user.repository.SpringDataMysqlUserRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses = {
        SpringDataMysqlUserRepository.class,
        SpringDataMysqlHotelRepository.class,
        SpringDataMysqlGuestRepository.class,
        SpringDataMysqlRoomRepository.class,
        SpringDataMysqlReservationRepository.class,
        SpringDataMysqlProfileRepository.class})
public class MySqlDbConfiguration {
}
