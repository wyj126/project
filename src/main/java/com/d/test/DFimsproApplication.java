  package com.d.test;

import java.util.TimeZone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.d"})
@MapperScan("com.d.mapper")
public class DFimsproApplication {

	public static void main(String[] args) {
		SpringApplication.run(DFimsproApplication.class, args);
	}
	
	
}
