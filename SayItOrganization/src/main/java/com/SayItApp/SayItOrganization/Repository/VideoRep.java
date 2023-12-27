package com.SayItApp.SayItOrganization.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SayItApp.SayItOrganization.Models.Video;

@Repository
public interface VideoRep extends JpaRepository<Video,Long> {
    
}
