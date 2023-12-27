package com.SayItApp.SayItOrganization.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SayItApp.SayItOrganization.Models.Postimet;

@Repository
public interface PostimetRepro  extends JpaRepository<Postimet, Long>{
    
}
