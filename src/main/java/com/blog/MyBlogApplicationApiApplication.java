package com.blog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyBlogApplicationApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBlogApplicationApiApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
	}

    int a=10;

}
