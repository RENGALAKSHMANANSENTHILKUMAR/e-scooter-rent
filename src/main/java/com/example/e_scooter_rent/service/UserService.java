package com.example.e_scooter_rent.service;

import com.example.e_scooter_rent.model.User;
import com.example.e_scooter_rent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user){
        return userRepository.save(user);
    }

    public Optional<User> login(String email, String password){

        return userRepository.findByEmail(email).filter(user -> user.getPassword().equals(password));
    }
}
