package com.SayItApp.SayItOrganization.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SayItApp.SayItOrganization.Models.User;
@Repository
public interface UserReprository extends JpaRepository<User, Long>{

    Optional<User> findByUsername(String username);
    
}
