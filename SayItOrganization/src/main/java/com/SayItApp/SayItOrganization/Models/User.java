package com.SayItApp.SayItOrganization.Models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    //private List<Authority> authorities = new ArrayList<>();


public User(){
    
}
    
    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
       
       
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
  
   /*@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add( new Authority("ROLE_STUDENTS"));

        return roles;
            
        
        // TODO Auto-generated method stub
     
    }
 */ 


 @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Authority> authorities = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Authority authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }
        return grantedAuthorities;
    }
    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
      return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
       return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
      return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
       return true;
    }

   

    

    
}
