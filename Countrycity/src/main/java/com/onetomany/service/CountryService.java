package com.onetomany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.onetomany.CostamException.ProductNotFountException;
import com.onetomany.Dao.CityRepository;
import com.onetomany.Dao.CountryREpository;
import com.onetomany.pojo.Contry;

@Service
public class CountryService {
 @Autowired
	private CityRepository cityRepo;
 
 private CountryREpository countryRepo;
	
 public Contry addCountry(Contry country) {
		return countryRepo.save(country);
	}

 public List<Contry> getAllCountry(Contry country)
 {
	 return  countryRepo.findAll();
 }

  public  Contry updateCountry(Contry country)
  {
	
	  Optional<Contry>isCountryFount = countryRepo.findById(country.getId());
	  
	  if(isCountryFount.isPresent())
	  {
		  return countryRepo.save(country);
	  }
	  throw new ProductNotFountException("Product Not Fount");
  }
  
  public  Contry deleteCountry(int id)
  {
	  Optional<Contry> isDeleteFound=countryRepo.findById(id);
	  //Contry country1= isDeleteFound.get();
	if(isDeleteFound.isPresent())
	{
		countryRepo.deleteById(id);
	}
	throw new ProductNotFountException("Product Not found");
	 }
  
 }
	

