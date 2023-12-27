package com.SayItApp.SayItOrganization.Models;

import java.sql.Blob;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.web.multipart.MultipartFile;

public class TestData {
          @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private MultipartFile data;
public TestData(){

}



public TestData(Long id, MultipartFile data) {
    this.id = id;
    this.data = data;
}



public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public MultipartFile getData() {
    return data;
}
public void setData(MultipartFile data) {
    this.data = data;
}
    

}
