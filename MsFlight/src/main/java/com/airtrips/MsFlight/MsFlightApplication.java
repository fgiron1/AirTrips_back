package com.airtrips.MsFlight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MsFlightApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsFlightApplication.class, args);
	}

}
