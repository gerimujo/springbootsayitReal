package com.SayItApp.SayItOrganization.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SayItApp.SayItOrganization.Models.AuthCredentialsRequest;
import com.SayItApp.SayItOrganization.Models.Authority;
import com.SayItApp.SayItOrganization.Models.User;
import com.SayItApp.SayItOrganization.Repository.AuthorityReprository;
import com.SayItApp.SayItOrganization.Repository.UserReprository;
import com.SayItApp.SayItOrganization.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired 
    UserReprository userReprository;
@Autowired
 AuthorityReprository authorityReprository;

    @PostMapping(value="getdata")
    public  ResponseEntity<String> encode_password(@RequestBody Authority auth){
   try{ 
       authorityReprository.save(auth);



    //Optional<User> data = userReprository.fin;
  
  //  ObjectMapper resp1 =  new ObjectMapper();
  // return ResponseEntity.ok(resp1.writeValueAsString(data));
return ResponseEntity.ok("done");
}catch(Exception e){
       return ResponseEntity.ok(e.toString());

}
  
    }



    @GetMapping(value="getdata1")
      public  ResponseEntity<String> funtion1(){
   try{ 
     
List<Authority> dataq =  authorityReprository.findAll();
ObjectMapper res1= new ObjectMapper();
return ResponseEntity.ok(res1.writeValueAsString(dataq));
    //Optional<User> data = userReprository.fin;
  
  //  ObjectMapper resp1 =  new ObjectMapper();
  // return ResponseEntity.ok(resp1.writeValueAsString(data));
//return ResponseEntity.ok("done");
}catch(Exception e){
       return ResponseEntity.ok(e.toString());

}
  
    }

  @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody AuthCredentialsRequest request){
        try {
            Authentication authenticate = authenticationManager
                .authenticate(
                    new UsernamePasswordAuthenticationToken(
                     
                        request.getUsername(), request.getPassword()
                    )
                );

            User user = (User) authenticate.getPrincipal();
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.AUTHORIZATION,  jwtUtil.generateToken(user));
            
            return ResponseEntity.ok()
            .headers(headers)
            .body(user);
         
        } catch (BadCredentialsException ex) {
         //   return ResponseEntity.status(200).body(request);
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }


    
}
