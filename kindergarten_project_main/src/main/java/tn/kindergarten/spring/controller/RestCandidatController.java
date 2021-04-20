package tn.kindergarten.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.kindergarten.spring.entities.Candidat;
import tn.kindergarten.spring.entities.Evenement;
import tn.kindergarten.spring.message.ResponseMessage;
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
		
		
		@PostMapping(value = "/ajoutercandidat")
		@ResponseBody
	    public  void ajoutercandidat(@RequestBody Candidat candidat)  
		{  String message = "sucess";
		
		
		icandidatservice.ajoutercand(candidat);
		      

		
		}
	
}
