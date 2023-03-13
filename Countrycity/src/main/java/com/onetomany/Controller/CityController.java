package com.onetomany.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onetomany.Dao.CityRepository;
import com.onetomany.pojo.City;
import com.onetomany.service.CityService;

@RestController
public class CityController {
@Autowired
	private CityService  cityservice;
	
@PostMapping("/AddCity")
public ResponseEntity<?>  addCit(City city)
{
	return ResponseEntity.ok(cityservice.addCity(city));
	}
@GetMapping("/getcity")
public ResponseEntity<?> getCity(City city)
{
	 return ResponseEntity.ok(cityservice.getAllCities(city));
}@GetMapping("/updateCity")
 
 public ResponseEntity<?>updateCity(@RequestBody City city){
 {
	 try
	 {
	return ResponseEntity.ok(cityservice.updtaeCities(city));
	 }
	 catch(Exception e)
	 {
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		
	 }
 }
 }
 
 @DeleteMapping("/deletecity{id}")
 public ResponseEntity<?> deletecities(@PathVariable int  id)
 {
	 try
	 {
		 cityservice.deleteCity(id);
		 return ResponseEntity.ok(null);
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
		 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		 }
 }
}

