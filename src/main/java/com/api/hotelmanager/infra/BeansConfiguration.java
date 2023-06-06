package com.api.hotelmanager.infra;

import com.api.hotelmanager.HotelmanagerApplication;
import com.api.hotelmanager.modules.user.mapper.UserMapper;
import com.api.hotelmanager.modules.user.repository.IUserRepository;
import com.api.hotelmanager.modules.profile.repository.ProfileRepository;
import com.api.hotelmanager.modules.user.service.IUserService;
import com.api.hotelmanager.modules.user.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BeansConfiguration {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public IUserService userService(final IUserRepository userRepository,
                                    final UserMapper mapper,
                                    final BCryptPasswordEncoder bcrypt,
                                    final ProfileRepository profileRepository){
        return new UserServiceImpl(userRepository, mapper, bcrypt, profileRepository);
    }

}
