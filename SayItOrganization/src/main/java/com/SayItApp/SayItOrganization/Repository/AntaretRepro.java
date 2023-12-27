package com.SayItApp.SayItOrganization.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SayItApp.SayItOrganization.Models.Antaret;

@Repository
public interface AntaretRepro extends JpaRepository<Antaret, Long> {
    
}
