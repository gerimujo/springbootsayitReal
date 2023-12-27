package com.SayItApp.SayItOrganization.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SayItApp.SayItOrganization.Models.Pjesmarresit;

@Repository
public interface PjesemarresitRepro  extends JpaRepository<Pjesmarresit, Long>{
    List<Pjesmarresit> findByNjoftimetId(Long njoftimetId);

}
