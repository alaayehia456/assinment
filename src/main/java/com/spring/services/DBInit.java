package com.spring.services;

import com.spring.Dao.AuthoritiesDao;
import com.spring.Dao.userDao;
import com.spring.model.Authorities;
import com.spring.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DBInit implements CommandLineRunner {

    private userDao userRepository;
    private AuthoritiesDao authoritiesRepository;

    @Autowired
    public DBInit(userDao userRepository,AuthoritiesDao authoritiesRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authoritiesRepository = authoritiesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private PasswordEncoder passwordEncoder;

    public DBInit(userDao userRepository, AuthoritiesDao authoritiesRepository) {
        this.userRepository = userRepository;
        this.authoritiesRepository = authoritiesRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        this.userRepository.deleteAll();
        user admin = new user("ahmed",passwordEncoder.encode("ahmed123"),"20","alex",1);
        admin.setAuthorities(this.authoritiesRepository.findAll());
        userRepository.save(admin);
        /////////////////////////////////////////////////////////////////////////
        user manger = new user("yaser",passwordEncoder.encode("yaser123"),"20","alex",1);
        Authorities mangerAuthorities1 = authoritiesRepository.findById(2L).get();
        Authorities mangerAuthorities2 = authoritiesRepository.findById(3L).get();
        Authorities mangerAuthorities3 = authoritiesRepository.findById(5L).get();
        Authorities mangerAuthorities4 = authoritiesRepository.findById(6L).get();
        manger.getAuthorities().add(mangerAuthorities1);
        manger.getAuthorities().add(mangerAuthorities2);
        manger.getAuthorities().add(mangerAuthorities3);
        manger.getAuthorities().add(mangerAuthorities4);
        userRepository.save(manger);
        /////////////////////////////////////////////////////////////////////////
        user user = new user("karim",passwordEncoder.encode("karim123"),"20","alex",1);
        Authorities userAuthorities1 = authoritiesRepository.findById(3L).get();
        Authorities userAuthorities2 = authoritiesRepository.findById(6L).get();
        user.getAuthorities().add(userAuthorities2);
        userRepository.save(user);
    }
}