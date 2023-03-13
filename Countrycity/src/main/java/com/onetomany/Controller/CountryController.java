package com.onetomany.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onetomany.pojo.Contry;
import com.onetomany.service.CountryService;

@RestController
public class CountryController {

	@Autowired
	private CountryService countryServic;
	@PostMapping("/addCountry")
	public  ResponseEntity<?> addCountry(Contry country)
	{
		System.err.println("Country" +country.getName());
		return ResponseEntity.ok().body(countryServic.addCountry(country));
	 	
	}
	
	@GetMapping("/getallcountry")
	
	public ResponseEntity<?> getAllCountry(Contry country)
	{
		return ResponseEntity.ok(countryServic.addCountry(country));// work same 
	
	}
	
	@PutMapping("/updatecountry")

	public ResponseEntity<?> updateCountry(Contry country)
	{
		try
		{
			return ResponseEntity.ok(countryServic.updateCountry(country));
		}
					
					catch(Exception e)
					{
						e.printStackTrace();
						return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
					}
		}
	
	@DeleteMapping("/deletecountry{id}")
	
	public ResponseEntity<?> deleteCountry(int id)
	{
		try {
			countryServic.deleteCountry(id);
			return ResponseEntity.ok(null);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
	}
	}

