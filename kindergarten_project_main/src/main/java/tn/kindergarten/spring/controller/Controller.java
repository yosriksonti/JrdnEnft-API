package tn.kindergarten.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.kindergarten.spring.service.Service;
import tn.kindergarten.spring.service.SmsRequest;


	@RestController
	@RequestMapping("api/v1/sms")
	public class Controller {

	  private final Service service;

	   @Autowired
	   public Controller(Service service) {
	      this.service = service;
	   }

	   @PostMapping
	    public void sendSms(@RequestBody SmsRequest smsRequest) {
	       service.sendSms(smsRequest);
	    }
	}

