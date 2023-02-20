package com.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Charity;

public interface CharityRepository extends JpaRepository<Charity,Integer>{

    
    @Query("FROM Charity c WHERE c.charityId = :charityId")
    Charity findCharityById(@Param("charityId") int charityId);
    
   
}