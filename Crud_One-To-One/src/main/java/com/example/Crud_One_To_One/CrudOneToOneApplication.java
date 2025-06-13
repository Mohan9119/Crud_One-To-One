package com.example.Crud_One_To_One;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudOneToOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudOneToOneApplication.class, args);
	}

}

/*
 
 http://localhost:9090/person
 
 {
  "firstName": "sai",
    "lastName": "b",
     "age": 22
}
 
 
 */