package com.example.springwebservice.repository;

import com.example.springwebservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByJsonWebToken(String jsonWebToken);
    Boolean existsByuserName(String userName);

    List<User> findByuserName(String userName);

}
