package com.andres.springboot.aop.sprinboot_aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class SprinbootAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprinbootAopApplication.class, args);
	}

}
