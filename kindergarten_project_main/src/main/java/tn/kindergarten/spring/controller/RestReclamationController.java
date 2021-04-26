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

import tn.kindergarten.spring.entities.Director;
import tn.kindergarten.spring.entities.Reclamation;
import tn.kindergarten.spring.service.IReclamationService;


@RestController

public class RestReclamationController {
	@Autowired
	IReclamationService  ireclamationservice;
	
	@PostMapping("/addReclamation")
	@ResponseBody
	public Reclamation ajouterReclamation(@RequestBody Reclamation reclamation)
	{
		ireclamationservice.addReclamation(reclamation);
		return reclamation;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Reclamation>> getAll() {
		return new ResponseEntity<> (ireclamationservice.getAll(), HttpStatus.OK);
	}
	@GetMapping("/getrecParentById/{id}")
	public ResponseEntity<List<Reclamation>> getRecByParentId(@PathVariable("id") int parentId){
		return new ResponseEntity<> (ireclamationservice.getRecByParentId(parentId), HttpStatus.OK);
	}
	@GetMapping("/Reclamation/{id}")
	@ResponseBody
	public Reclamation findDirector(@PathVariable("id") int id )
	{
		return ireclamationservice.getRecById(id);
	}
	
	

}
