package com.java.trackingNumberGenerator;


import com.java.trackingNumberGenerator.entity.Tracking;
import com.java.trackingNumberGenerator.repository.TrackingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;

@SpringBootApplication
public class TrackingNumberGeneratorApplication {
	public static void main(String[] args) {
		SpringApplication.run(TrackingNumberGeneratorApplication.class, args);
	}
}
