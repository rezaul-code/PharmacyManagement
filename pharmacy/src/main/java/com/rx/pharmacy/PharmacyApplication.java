package com.rx.pharmacy;

import java.io.IOException;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rx.pharmacy.util.DatabaseInitializer;

import javafx.application.Application;

@SpringBootApplication
public class PharmacyApplication {

	public static void main(String[] args) throws IOException {
		
		// ✅ Ensure DB is ready before starting
        DatabaseInitializer.init();
		
//		SpringApplication.run(PharmacyApplication.class, args);
		 Application.launch(JavaFxApp.class, args);
	}

}
