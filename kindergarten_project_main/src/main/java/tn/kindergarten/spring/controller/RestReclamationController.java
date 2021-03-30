package tn.kindergarten.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
<<<<<<< Updated upstream
=======
	@GetMapping("/getDaycareById")
	public ResponseEntity<List<Reclamation>> getRecByParentId(int parentId){
		return new ResponseEntity<> (ireclamationservice.getRecByParentId(parentId), HttpStatus.OK);
	}
	@GetMapping("/ getById")
	public ResponseEntity <Reclamation>  getRecById(int id){
		return new ResponseEntity<Reclamation>(ireclamationservice.getRecById(id),HttpStatus.OK);
	}
>>>>>>> Stashed changes
	
	

}
