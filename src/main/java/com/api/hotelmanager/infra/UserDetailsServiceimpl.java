package com.api.hotelmanager.infra;

import com.api.hotelmanager.modules.user.entity.User;
import com.api.hotelmanager.modules.user.repository.IUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserDetailsServiceimpl implements UserDetailsService {

    final IUserRepository IUserRepository;

    public UserDetailsServiceimpl(IUserRepository IUserRepository){
        this.IUserRepository = IUserRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = IUserRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with this login:" + username));

        return user;

    }
}
