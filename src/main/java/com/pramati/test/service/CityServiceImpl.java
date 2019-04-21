	package com.pramati.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pramati.test.exception.CityNotFoundException;
import com.pramati.test.repository.City;
import com.pramati.test.repository.CityDataRepository;

@Service("cityService")
@Transactional(readOnly = true)
public class CityServiceImpl implements CityService {

	@Autowired
	CityDataRepository cityRepositiry;

	@Override
	public List<City> getCityList(String serchQuery, int atMost) {
		List<City> cityList = cityRepositiry.find(serchQuery, atMost);
		if (cityList == null || cityList.size() == 0) {
			throw new CityNotFoundException("No City Found with Name - " + serchQuery);
		}

		return cityList;

	}

}
