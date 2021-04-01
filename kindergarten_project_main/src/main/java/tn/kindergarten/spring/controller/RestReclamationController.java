package tn.kindergarten.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.kindergarten.spring.entities.Reclamation;
import tn.kindergarten.spring.service.IReclamationService;


@RestController

public class RestReclamationController {
	@Autowired
	IReclamationService  ireclamationservice;
	
	@PostMapping("/reclamation/add")
	public ResponseEntity <Reclamation> ajouterReclamation(@RequestBody Reclamation reclamation)
	{
		return new ResponseEntity<Reclamation>(ireclamationservice.addReclamation(reclamation),HttpStatus.OK);
		 
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Reclamation>> getAll() {
		return new ResponseEntity<> (ireclamationservice.getAll(), HttpStatus.OK);
	}
	@GetMapping("/getRecParentById/{id}")
	public ResponseEntity<List<Reclamation>> getRecByParentId(@PathVariable("id")int parentId){
		return new ResponseEntity<> (ireclamationservice.getRecByParentId(parentId), HttpStatus.OK);
	}
	@GetMapping("/getById/{id}")
	public ResponseEntity <Reclamation>  getRecById(@PathVariable("id")int id){
		return new ResponseEntity<Reclamation>(ireclamationservice.getRecById(id),HttpStatus.OK);
	}
	
	

}

