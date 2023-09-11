package com.unideb.sfm.Szoftverfejlesztesmernokoknek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SzoftverfejlesztesMernokoknekApplication {

	public static void main(String[] args) {
		SpringApplication.run(SzoftverfejlesztesMernokoknekApplication.class, args);
		//Open browser
		//Teszt
		try {
			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:8080");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
