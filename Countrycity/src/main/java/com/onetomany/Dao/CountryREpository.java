package com.onetomany.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onetomany.pojo.Contry;

public interface CountryREpository extends JpaRepository<Contry, Integer> {

}
