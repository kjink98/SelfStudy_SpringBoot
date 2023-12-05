package com.dogether.service;

import org.springframework.stereotype.Service;

import com.dogether.domain.User;
import com.dogether.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    
    public boolean insertUser(User user) {
        return userRepository.insertUser(user);
    }
}
