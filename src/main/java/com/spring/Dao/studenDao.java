package com.spring.Dao;

import com.spring.model.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface studenDao extends JpaRepository<student,Long> {

    public Optional<student> findById(@Param("id") Long id);

}
