package com.spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {

    private user User;

    @Autowired
    public UserPrincipal(user User) {
        this.User = User;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        this.User.getAuthorities().forEach(p -> {
            GrantedAuthority authority = new SimpleGrantedAuthority(p.getAuthoritieName());
            authorities.add(authority);
        });
        return authorities;
    }
    @Override
    public String getPassword() {
        return this.User.getPassword();
    }

    @Override
    public String getUsername() {
        return this.User.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.User.getActive() == 1;
    }
}