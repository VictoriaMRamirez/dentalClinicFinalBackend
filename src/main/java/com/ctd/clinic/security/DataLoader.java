package com.ctd.clinic.security;

import com.ctd.clinic.entity.login.User;
import com.ctd.clinic.entity.login.UserRoles;
import com.ctd.clinic.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    IUserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode("victoria");
        userRepository.save(new User("victoria", "victoria", "victoria@gmail.com", password, UserRoles.ADMIN));
    }
}
