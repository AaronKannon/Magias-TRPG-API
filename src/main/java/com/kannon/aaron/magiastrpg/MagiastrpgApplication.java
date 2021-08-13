package com.kannon.aaron.magiastrpg;

import com.kannon.aaron.magiastrpg.controller.JSONReader.Formatter;
import com.kannon.aaron.magiastrpg.model.Magia;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class MagiastrpgApplication {

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(MagiastrpgApplication.class, args);

		Formatter formatter = new Formatter();

		List<Magia> print = formatter.JSONFormatter();

		//Iterator<Magia> iterator = print.iterator();

		//while (iterator.hasNext()){
			//System.out.println(iterator.next());
		//}

	}


}
