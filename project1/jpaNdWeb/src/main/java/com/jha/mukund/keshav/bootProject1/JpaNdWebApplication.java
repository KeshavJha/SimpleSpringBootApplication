package com.jha.mukund.keshav.bootProject1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.jha.mukund.keshav.bootProject1.config.AppConfig;
import com.jha.mukund.keshav.bootProject1.config.SampleVideoConfig;

@SpringBootApplication // Initializes as spring boot application, and includes all required classPath requirements
@EnableConfigurationProperties({AppConfig.class, SampleVideoConfig.class}) // Include configuration classes as array, and then they can be Autowired into all Components
public class JpaNdWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaNdWebApplication.class, args);
	}

}
