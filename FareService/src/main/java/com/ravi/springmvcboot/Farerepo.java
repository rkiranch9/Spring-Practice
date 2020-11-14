package com.ravi.springmvcboot;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ravi.springmvcboot.model.Fare;

public interface Farerepo extends JpaRepository<Fare, String>{
	
	@Query("FROM Fare WHERE bustype = ?1")
	Fare getFarePerKm(String type);
	
    //@Query(value = "SELECT fareperkm from Fare b where b.bustype = ?1;", nativeQuery = true)
	//Fare getFarePerKm(@Param("type") String type);
	
	//@Query("select fareperkm from busfare where bustype = :type")
	//Fare getFarePerKm(@Param("type") String type);
	
	@Query("FROM Fare WHERE bustype IN (?1)")
	List<Fare> getAllFarePerKm(String[] types);
}
