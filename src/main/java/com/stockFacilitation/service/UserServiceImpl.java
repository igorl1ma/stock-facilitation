package com.stockFacilitation.service;

import com.stockFacilitation.entity.User;
import com.stockFacilitation.repository.UserRepository;
import com.stockFacilitation.util.StockFacilitationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(User newUser) {
        newUser.setPassword(new BCryptPasswordEncoder().encode(newUser.getPassword()));
        userRepository.save(newUser);
    }

    @Override
    public void patchUser(User updateUser) {
        var user = StockFacilitationUtils.generateUpdateUser(userRepository.findByUsername(updateUser.getUsername()),updateUser);
        userRepository.save(user);
    }
}
