package com.spring.securityconfig;

import com.spring.Dao.userDao;
import com.spring.model.UserPrincipal;
import com.spring.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    @Autowired
    private userDao userdao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        user User=userdao.findByUserName(username);
        UserPrincipal userPrincipal=new UserPrincipal(User);

        return userPrincipal;
    }
}
