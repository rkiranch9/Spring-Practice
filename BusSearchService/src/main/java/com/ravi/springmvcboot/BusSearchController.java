package com.ravi.springmvcboot;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	

	@GetMapping(path = "bussearch", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getRoutes() {
		System.out.println("Inside getRoutes method");
		List<BusSearch> routes = repo.findAll();
		
		// ******* Creating JSON Array Only with From and To values *********
		JSONArray routesList = new JSONArray();
		for(BusSearch route:routes) {
			JSONObject obj = new JSONObject();
			obj.put("From", route.getFrom());
			obj.put("To", route.getTo());
			routesList.put(obj);
		}	
		
		// ******* REMOVING DUPLICATES FROM THE JSON Array *************
		JSONArray noDupRoutesList = new JSONArray();
		HashMap<String, String> uniquelist = new HashMap<String, String>();
		
		for(int i=0; i< routesList.length() ;i++) {
			String duplicate = "False";
			JSONObject routesListobj = routesList.getJSONObject(i);
			Set set = (Set) uniquelist.entrySet();
			Iterator iterator = set.iterator();
			while (iterator.hasNext()) {
				Map.Entry mapEntry = (Map.Entry) iterator.next();
				String key   = (String) mapEntry.getKey();
				String value = (String) mapEntry.getValue();
				if (key.equals(routesListobj.getString("From")) && value.equals(routesListobj.getString("To")))
						duplicate = "True";
			}
			
			if (duplicate == "False") {
				uniquelist.put(routesListobj.getString("From"), routesListobj.getString("To"));
				System.out.println(routesListobj.getString("From") + " - " +routesListobj.getString("To"));
				noDupRoutesList.put(routesListobj);
			}
		}
		
		
		//System.out.println(routesList.toString());
		//System.out.println(noDupRoutesList.toString());
		//return routesList.toString();
		return noDupRoutesList.toString();
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
		
	
		RestTemplate restTemplate = new RestTemplate();
		
		String resourceUrl = "http://3.134.91.13:8080/getFares?bustype="+busTypesForFare
				+"&distance="+distanceForFare;
		//ResponseEntity<Object[]> response = restTemplate.getForEntity(resourceUrl,Object[].class); 

		// [{"FarePerSeat":7400,"BusType":"garuda"},{"FarePerSeat":1850,"BusType":"luxury"}]
		String s = restTemplate.exchange(resourceUrl, HttpMethod.GET,null,String.class).getBody();
		
		
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
