package tn.kindergarten.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.kindergarten.spring.entities.Candidat;
import tn.kindergarten.spring.service.Icandidatservice;

@RestController
public class RestCandidatController {
	
	@Autowired
	Icandidatservice icandidatservice;
	// URL : http://localhost:8080/SpringMVC/servlet/getAllcandodats
		@GetMapping(value = "/getAllcandodats")
	    @ResponseBody
		public List<Candidat> getAllcandodats() {
			
			return icandidatservice.getCandidates();
		}
}
