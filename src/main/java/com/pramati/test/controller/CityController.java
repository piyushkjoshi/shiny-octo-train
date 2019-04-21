package com.pramati.test.controller;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.test.repository.City;
import com.pramati.test.service.CityService;

@RestController
@Validated
public class CityController {

	@Autowired
	CityService cityService;

	@GetMapping("/suggest_cities")
	public ResponseEntity<List<City>> getCity(
			@RequestParam @Size(min = 5, message = "start length must be atleast 5 charater.") String start,
			@RequestParam  @Min(
		            value = 1,
		            message = "minimum value of atMost must be at least 1"
		    ) Integer atMost) {

		List<City> cityList = cityService.getCityList(start, atMost);
		return new ResponseEntity<List<City>>(cityList, HttpStatus.OK);
	}

}
