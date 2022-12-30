package com.stockFacilitation.util;

import com.stockFacilitation.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class StockFacilitationUtils {

    public static User generateUpdateUser(User user, User newUser){

        if (newUser.getUsername() != null) {
            user.setUsername(newUser.getUsername());
        }
        if (newUser.getPassword() != null) {
            user.setPassword(new BCryptPasswordEncoder().encode(newUser.getPassword()));
        }
        if (newUser.getName() != null) {
            user.setName(newUser.getName());
        }
        if (newUser.getAccountNonExpired() != null) {
            user.setAccountNonExpired(newUser.getAccountNonExpired());
        }
        if (newUser.getAccountNonLocked() != null) {
            user.setAccountNonLocked(newUser.getAccountNonLocked());
        }
        if (newUser.getCredentialsNonExpired() != null) {
            user.setCredentialsNonExpired(newUser.getCredentialsNonExpired());
        }
        if (newUser.getEnabled() != null) {
            user.setEnabled(newUser.getEnabled());
        }

        return user;
    }

}
