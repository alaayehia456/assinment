package com.spring.Dao;

import com.spring.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface userDao extends JpaRepository<user,Long> {

    public user findByUserName(@Param("userName") String userName);
}
