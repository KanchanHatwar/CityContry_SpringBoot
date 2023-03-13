package com.onetomany.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onetomany.pojo.City;
import com.onetomany.pojo.Contry;

public interface CityRepository extends JpaRepository<City, Integer>{

	
}
