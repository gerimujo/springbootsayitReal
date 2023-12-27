package com.SayItApp.SayItOrganization.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SayItApp.SayItOrganization.Models.PostimetMedia;

@Repository
public interface PostimetMediaRepro extends JpaRepository<PostimetMedia,Long> {
    
}
