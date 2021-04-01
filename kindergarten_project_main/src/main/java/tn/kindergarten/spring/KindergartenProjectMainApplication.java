package tn.kindergarten.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KindergartenProjectMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(KindergartenProjectMainApplication.class, args);
		
			
	}
	

}
