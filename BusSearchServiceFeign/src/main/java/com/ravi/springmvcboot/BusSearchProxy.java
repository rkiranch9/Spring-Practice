package com.ravi.springmvcboot;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name="bussearch-proxy", url="http://3.16.155.85:8080")
public interface BusSearchProxy {
	
	// Internally this url is generated by the Feign Client
	// url = "http://3.134.91.13:8080/getFares?bustype="+busTypesForFare +"&distance="+distanceForFare;
	
	@RequestMapping(value="/getFares")
	public abstract String getFares(@RequestParam(value="bustype") String busTypesForFare, 
										@RequestParam(value="distance") int distanceForFare);
}
