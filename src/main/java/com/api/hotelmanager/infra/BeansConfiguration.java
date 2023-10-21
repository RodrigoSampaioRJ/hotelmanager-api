package com.api.hotelmanager.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.api.hotelmanager.modules.guest.repository.IGuestRepository;
import com.api.hotelmanager.modules.hotel.mapper.HotelMapper;
import com.api.hotelmanager.modules.hotel.repository.IHotelRepository;
import com.api.hotelmanager.modules.hotel.service.HotelServiceImpl;
import com.api.hotelmanager.modules.hotel.service.IHotelService;
import com.api.hotelmanager.modules.profile.repository.IProfileRepository;
import com.api.hotelmanager.modules.reservation.mapper.ReservationMapper;
import com.api.hotelmanager.modules.reservation.repository.IReservationRepository;
import com.api.hotelmanager.modules.reservation.service.IReservationService;
import com.api.hotelmanager.modules.reservation.service.ReservationServiceImpl;
import com.api.hotelmanager.modules.room.mapper.RoomMapper;
import com.api.hotelmanager.modules.room.repository.IRoomRepository;
import com.api.hotelmanager.modules.room.service.IRoomService;
import com.api.hotelmanager.modules.room.service.RoomServiceImpl;
import com.api.hotelmanager.modules.user.mapper.UserMapper;
import com.api.hotelmanager.modules.user.repository.IUserRepository;
import com.api.hotelmanager.modules.user.service.IUserService;
import com.api.hotelmanager.modules.user.service.UserServiceImpl;

@Configuration
public class BeansConfiguration {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public IUserService userService(final IUserRepository userRepository,
                                    final BCryptPasswordEncoder bcrypt,
                                    final IProfileRepository profileRepository,
                                    final UserMapper mapper){
        return new UserServiceImpl(userRepository, bcrypt, profileRepository, mapper);
    }

    @Bean
    public IReservationService reservationService(final IGuestRepository guestRepository,final IRoomRepository roomRepository, final IReservationRepository reservationRepository, final ReservationMapper mapper){
        return new ReservationServiceImpl(guestRepository,roomRepository,reservationRepository, mapper);
    }

    // @Bean
    // public IGuestService guestService(final IGuestRepository guestRepository, final ModelMapper modelMapper){
    //     return new GuestServiceImpl(guestRepository, modelMapper);
    // }

    @Bean
    public IRoomService roomService(final IRoomRepository roomRepository, final IHotelRepository hotelRepository, final RoomMapper mapper){
        return new RoomServiceImpl(roomRepository, hotelRepository, mapper);
    }

    @Bean
    public IHotelService hotelService(final IHotelRepository hotelRepository, final HotelMapper mapper){
        return new HotelServiceImpl(hotelRepository, mapper);
    }

}
