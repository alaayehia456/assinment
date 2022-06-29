package com.spring.Dao;

import com.spring.model.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesDao  extends JpaRepository<Authorities,Long> {
}
