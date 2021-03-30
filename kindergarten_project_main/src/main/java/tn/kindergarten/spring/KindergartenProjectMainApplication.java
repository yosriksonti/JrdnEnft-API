package tn.kindergarten.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import tn.kindergarten.spring.service.SendEmailService;
>>>>>>> Stashed changes
=======
import org.springframework.web.bind.annotation.RestController;
>>>>>>> Stashed changes

@SpringBootApplication
@RestController
public class KindergartenProjectMainApplication {
  
	@Autowired
	SendEmailService sendemailservice ;
	public static void main(String[] args) {
	
		SpringApplication.run(KindergartenProjectMainApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void triggerWhenStarts() {
		sendemailservice.sendEmail("y.kossontini@gmail.com", "barbouchejihen1@gmail.com", "ahlaaa bik si 3ala", "n7eb ma3mel choclata :D");
		
		
	}
	
	
	}


