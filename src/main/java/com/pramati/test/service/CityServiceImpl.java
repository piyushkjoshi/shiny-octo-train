package com.pramati.test.service;

import java.util.Iterator;
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
	public String getCityList(String serchQuery, int atMost) {
		List<City> cityList = cityRepositiry.find(serchQuery, atMost);
		if (cityList == null || cityList.size() == 0) {
			throw new CityNotFoundException("No City Found with Name - " + serchQuery);
		}

		String cityName = "";
		for (City s : cityList) {
			cityName = cityName + "\n" + s.getName();
		}

		return cityName;

	}

}
