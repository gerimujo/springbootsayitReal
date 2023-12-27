package com.SayItApp;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SayItApp.SayItOrganization.Models.User;
import com.SayItApp.SayItOrganization.Repository.UserReprository;
@RestController
public class testfile {
  

    @Autowired UserReprository userReprository;

    @GetMapping(value="getdata")
    public ResponseEntity<String> encode_password(){
    List<User> data = userReprository.findAll();
    Integer result =- data.size();
return ResponseEntity.ok(String.valueOf(result));

  
    }
   
} 

/*public class testfile {
    @Test
    public void encode_password(){
      PasswordEncoder pass = new BCryptPasswordEncoder();
      System.out.println(pass.encode("geri.mujo"));
    }}*/