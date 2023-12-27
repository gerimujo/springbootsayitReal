package com.SayItApp.SayItOrganization.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.SayItApp.SayItOrganization.Models.Authority;


@Repository
public interface AuthorityReprository  extends JpaRepository<Authority, Long>{
    
}
