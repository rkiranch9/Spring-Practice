package com.ravi.springmvcboot;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.springmvcboot.model.Fare;

@RestController
public class FareController {
	
	@Autowired
	Farerepo repo;
	
	@SuppressWarnings("unchecked")
	@GetMapping(path = "getFares", produces = "application/json")
	public List<Fare> getSpecificFares(@RequestParam("bustype") String[] bustype, @RequestParam("distance") int distance) {
		System.out.println("Inside testing method");
		//int distance = 350;
		//String[] types = {"luxury","garuda"};
		List<Fare> fares = repo.getAllFarePerKm(bustype);
		JSONArray faresList = new JSONArray();
		
		for(Fare f:fares) {
			JSONObject jsonFareBbject = new JSONObject();
			jsonFareBbject.put("BusType", f.getBustype());
			jsonFareBbject.put("FarePerSeat", f.getFareperkm() * distance);
			faresList.add(jsonFareBbject);
		}	
		//return fares;
		return faresList;
	}
	
		
	@GetMapping("fares")
	public List<Fare> getFares() {
		System.out.println("Inside getFares method");
		List<Fare> fares = repo.findAll();
		return fares;
	}
	
	@GetMapping("fares/{type}/{dist}")
	public int getFarebyTypeDist(@PathVariable("type") String type, @PathVariable("dist") int distance) {
		Fare fare = repo.getFarePerKm(type);
		if (fare != null)
			return fare.getFareperkm() * distance;
		else
			return 0;
	}
	

	@PostMapping("fares")
	public Fare addfare(Fare fare) {
		System.out.println("Inside postFare method");
		repo.save(fare);
		return fare;
	}
	
}
