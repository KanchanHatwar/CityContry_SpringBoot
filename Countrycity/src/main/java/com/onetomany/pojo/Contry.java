package com.onetomany.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Contry {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 
	
	private int id;
    private String name;
  
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    @JsonIgnore
    Set<City> cities=new HashSet<>();

	public Contry(int id, String name, Set<City> cities) {
		super();
		this.id = id;
		this.name = name;
		this.cities = cities;
	}

	public Contry() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		return "Contry [id=" + id + ", name=" + name + ", cities=" + cities + "]";
	}

	
    
    
}
    
