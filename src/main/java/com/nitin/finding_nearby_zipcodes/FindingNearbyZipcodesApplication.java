package com.nitin.finding_nearby_zipcodes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FindingNearbyZipcodesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindingNearbyZipcodesApplication.class, args);
	}

}
