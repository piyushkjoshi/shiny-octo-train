package com.pramati.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CityDataRepository extends JpaRepository<City,String>{

	
	@Query(value = "SELECT * FROM City c WHERE " +
            "LOWER(c.city_name) LIKE LOWER(CONCAT('%',:serchQuery, '%')) ORDER BY c.city_name ASC LIMIT :atMost",
            nativeQuery = true
    )
	public List<City> find(@Param("serchQuery") String serchQuery,@Param("atMost") int atMost);
	

}


