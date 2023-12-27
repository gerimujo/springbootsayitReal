package com.SayItApp.SayItOrganization.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.SayItApp.SayItOrganization.Models.User;
import com.SayItApp.SayItOrganization.Repository.UserReprository;
import com.SayItApp.SayItOrganization.util.CustomPasswordEncoder;
  
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
@Autowired
private CustomPasswordEncoder passwordEncoder;
@Autowired
private UserReprository userRepo;

/*public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'loadUserByUsername'");
}
*/
 @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> userOpt =   userRepo.findByUsername(username);
    return userOpt.orElseThrow(()->new UsernameNotFoundException("Invalid Credintials"));
    
    }
    
}
