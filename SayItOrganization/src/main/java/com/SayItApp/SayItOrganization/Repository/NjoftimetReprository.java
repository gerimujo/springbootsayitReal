package com.SayItApp.SayItOrganization.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SayItApp.SayItOrganization.Models.Njoftimet;

@Repository
public interface NjoftimetReprository extends JpaRepository<Njoftimet, Long>{
    
}
