package tn.kindergarten.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {
	
	@Autowired
    JavaMailSender javaMailSender ;
	
	public void sendEmail(String to ,String From, String body ,String topic) {
	 SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
	 System.out.println(to + " " + From + " " + body + " " + topic);
	 simpleMailMessage.setFrom(From);
	 simpleMailMessage.setTo(to);
	 simpleMailMessage.setSubject(topic);
	 simpleMailMessage.setText(body);
	 
	 javaMailSender.send(simpleMailMessage);
	
	}

}
