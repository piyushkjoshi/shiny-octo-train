package com.pramati.test.service;

import java.util.List;

import com.pramati.test.repository.City;

public interface CityService {
	
	public List<City> getCityList(String nameToken, int atMost);

}
