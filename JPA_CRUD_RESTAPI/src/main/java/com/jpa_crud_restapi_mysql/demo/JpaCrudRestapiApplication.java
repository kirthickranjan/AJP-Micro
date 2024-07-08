package com.jpa_crud_restapi_mysql.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class JpaCrudRestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaCrudRestapiApplication.class, args);
	}

}
