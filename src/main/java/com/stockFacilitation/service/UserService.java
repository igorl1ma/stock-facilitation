package com.stockFacilitation.service;

import com.stockFacilitation.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> findAllUsers();
    User findByUsername(String username);
    void saveUser(User newUser);
    void patchUser(User newUser);

}
