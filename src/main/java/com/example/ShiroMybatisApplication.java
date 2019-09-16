package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
@MapperScan({"com.example.mapper"})
public class ShiroMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShiroMybatisApplication.class, args);
	}

}
