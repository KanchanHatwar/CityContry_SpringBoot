package com.onetomany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetomany.CostamException.ProductNotFoundException;
import com.onetomany.Dao.CityRepository;
import com.onetomany.pojo.City;

@Service
public class CityService {
@Autowired
	private CityRepository cityrepo;

public City addCity(City city)
{
	return cityrepo.save(null);
	
}

public List<City> getAllCities(City city)
{
	return cityrepo.findAll();
	
}

public City  updtaeCities(City city)
{
	Optional<City>cityData=cityrepo.findById(city.getId());
	
	if(cityData.isPresent())
	{
		return cityrepo.save(city);
	}
	else
	{
	throw new 	ProductNotFoundException("No product found for updating the data.");
	
	}
	
}
public void deleteCity(int id)
{
	Optional<City> deleteData=cityrepo.findById(id);
	
	if(deleteData.isPresent())
	{
	 cityrepo.deleteById(id);
	}
	else
	{
		throw new ProductNotFoundException("Not Found Data For Delete");
	}
}
}
