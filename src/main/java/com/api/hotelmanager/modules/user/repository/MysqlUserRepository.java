package com.api.hotelmanager.modules.user.repository;

import com.api.hotelmanager.modules.user.entity.User;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Primary
public class MysqlUserRepository implements IUserRepository {
    private final SpringDataMysqlUserRepository userRepository;

    public MysqlUserRepository(final SpringDataMysqlUserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    @Query("select u from User u where u.username like ?1")
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }
}
