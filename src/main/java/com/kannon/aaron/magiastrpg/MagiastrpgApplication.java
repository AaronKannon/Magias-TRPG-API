package com.kannon.aaron.magiastrpg;

import com.kannon.aaron.magiastrpg.controller.JSONReader.Formatter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

@SpringBootApplication
public class MagiastrpgApplication {

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(MagiastrpgApplication.class, args);

		Formatter formatter = new Formatter();

		formatter.JSONFormatter();

	}


}
