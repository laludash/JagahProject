package com.sangamone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;




@SpringBootApplication
//@ComponentScan(basePackages = {"com.sangamone"})
//@Configuration
@EnableSwagger2
public class JagahRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JagahRestApiApplication.class, args);
	}

}
