package com.ravi.springmvcboot;

import java.util.List;

import org.json.JSONArray;
//import org.json.simple.JSONObject;
import org.json.JSONObject;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ravi.springmvcboot.model.BusSearch;

@RestController
public class BusSearchController {
	
	@Autowired
	BusSearchRepo repo;
	
	@Autowired
	BusSearchProxy busproxy;
	

	@GetMapping("bussearch")
	public List<BusSearch> getFares() {
		System.out.println("Inside getFares method");
		List<BusSearch> buses = repo.findAll();
		return buses;
	}
	
	@GetMapping(path = "bussearch/{from}/{to}", produces = MediaType.APPLICATION_JSON_VALUE)
	//public List<BusSearch> getFarebyTypeDist(@PathVariable("from") String from, @PathVariable("to") String to) {
	public String getFarebyTypeDist(@PathVariable("from") String from, @PathVariable("to") String to) throws ParseException {
		
		System.out.println("Inside bussearch method");
		
		List<BusSearch> buses = repo.getBusTypes(from, to);
		//return buses;
		int distanceForFare = 0;
		String busTypesForFare = "";
		for(BusSearch bus:buses) {
			busTypesForFare += bus.getBustype() +",";
			distanceForFare = bus.getDistance();
		}
		busTypesForFare = busTypesForFare.substring(0, busTypesForFare.length()-1);
		//System.out.println(busTypesForFare);
		//System.out.println(distanceForFare);
		
	
	//	RestTemplate restTemplate = new RestTemplate();
		
	//	String resourceUrl = "http://3.134.91.13:8080/getFares?bustype="+busTypesForFare
	//			+"&distance="+distanceForFare;
		//ResponseEntity<Object[]> response = restTemplate.getForEntity(resourceUrl,Object[].class); 

		// [{"FarePerSeat":7400,"BusType":"garuda"},{"FarePerSeat":1850,"BusType":"luxury"}]
	//	String s = restTemplate.exchange(resourceUrl, HttpMethod.GET,null,String.class).getBody();
		
		String s = busproxy.getFares(busTypesForFare, distanceForFare);
		
		System.out.println("Data Received from FareService:"+ s);
		
		/*JSONArray jarray = new JSONArray(s);
		System.out.println("JSON Array : "+ jarray);
		for(int i=0; i< jarray.length();i++) {
			JSONObject obj = jarray.getJSONObject(i);
			int fareperseat = obj.getInt("FarePerSeat");
			String bustype = obj.getString("BusType");
		}
		String s2 = s.replace("\"", "");
		String s3 = s.replace("\"","\\\"");*/
		
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("Bus Services with fare from "+from+" to "+to,new JSONArray(s));
	
		return jsonobject.toString();
		
		
	}
	
	
	/*@PostMapping("fares")
	public BusSearch addfare(BusSearch fare) {
		System.out.println("Inside postFare method");
		repo.save(fare);
		return fare;
	}*/
	
}
