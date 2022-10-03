package com.codegym.service.user;

import com.codegym.model.User;
import com.codegym.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserService implements IUserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user) ;
    }

    @Override
    public void remove(Long id) {

    }
}
