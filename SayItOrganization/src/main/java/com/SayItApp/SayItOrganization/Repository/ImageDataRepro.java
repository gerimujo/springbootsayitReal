package com.SayItApp.SayItOrganization.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SayItApp.SayItOrganization.Models.ImageData;

@Repository
public interface ImageDataRepro  extends JpaRepository<ImageData,Long>{
    
}
