package com.ict4dev.benildo.userapi.service;

import com.ict4dev.benildo.userapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

    @Repository
    public interface UserRepository extends JpaRepository<User, Long> {
       // User findById(String id);
        List<User> queryByNomeLike(String name);
        User findByNuit(String nuit);
    }
