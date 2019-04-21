package com.pramati.test.repository;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class City implements Serializable {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public City(String name) {
		super();
		this.name = name;
	}

	public City() {
		super();
	}
	
	@Id
	@Column(name="cityName")
	private String name;
	 	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

		
}
