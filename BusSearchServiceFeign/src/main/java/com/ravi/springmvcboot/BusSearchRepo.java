package com.ravi.springmvcboot;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ravi.springmvcboot.model.BusSearch;

public interface BusSearchRepo extends JpaRepository<BusSearch, String>{
	
	@Query("FROM BusSearch WHERE source_city = ?1 and destination_city = ?2")
	List<BusSearch> getBusTypes(String from,String to);
	
    //@Query(value = "SELECT fareperkm from Fare b where b.bustype = ?1;", nativeQuery = true)
	//Fare getFarePerKm(@Param("type") String type);
	
	//@Query("select fareperkm from busfare where bustype = :type")
	//Fare getFarePerKm(@Param("type") String type);
	
	//@Query("FROM Fare WHERE bustype IN (?1)")
	//List<BusSearch> getAllFarePerKm(String[] types);
}
