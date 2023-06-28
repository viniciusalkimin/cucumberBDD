package br.com.alura.leilao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BDDLeilaoApplication {

	
	//-Dspring.profiles.active=test
	//-Dbrowser=firefox
	public static void main(String[] args) {
		SpringApplication.run(BDDLeilaoApplication.class, args);
	}
	
}
