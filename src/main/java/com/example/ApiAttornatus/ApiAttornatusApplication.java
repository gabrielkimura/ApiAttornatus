package com.example.ApiAttornatus;

;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.ApiAttornatus"})
public class ApiAttornatusApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ApiAttornatusApplication.class, args);
	}

}
