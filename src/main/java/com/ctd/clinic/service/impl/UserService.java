package com.ctd.clinic.service.impl;

import com.ctd.clinic.entity.login.User;
import com.ctd.clinic.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> foundUser = userRepository.findByUsername(username);

        if (foundUser.isPresent()) {
            return foundUser.get();
        } else {
            throw new UsernameNotFoundException("User's username not found");
        }
    }
}
