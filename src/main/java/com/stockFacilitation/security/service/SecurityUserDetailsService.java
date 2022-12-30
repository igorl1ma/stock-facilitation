package com.stockFacilitation.security.service;

import com.stockFacilitation.entity.User;
import com.stockFacilitation.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SecurityUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        var validateUser = userRepository.findByUsername(username);

        if(validateUser != null){

            return new org.springframework.security.core.userdetails.User(
                    validateUser.getUsername(),
                    validateUser.getPassword(),
                    validateUser.getEnabled(),
                    validateUser.getAccountNonExpired(),
                    validateUser.getCredentialsNonExpired(),
                    validateUser.getAccountNonLocked(),
                    new ArrayList<>());
        } else {
            throw  new UsernameNotFoundException("User not present");
        }
    }

    public void createUser(UserDetails user) {
        userRepository.save((User) user);
    }
}