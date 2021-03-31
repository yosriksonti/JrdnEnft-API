package tn.kindergarten.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.kindergarten.spring.entities.Parent;
import tn.kindergarten.spring.service.IParentService;

@RestController
@RequestMapping("api/parent")
public class RestParentController {
	
	@Autowired
	private IParentService parentService;
	
	@PostMapping("/add")
	public ResponseEntity<Parent> addParent(@Validated @RequestBody Parent parent) {
		Parent parent1 = parentService.addParent(parent);
		if(parent1 == null) new ResponseEntity<> (parent, HttpStatus.CONFLICT);
		return new ResponseEntity<> (parent1, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Parent>> allParents() {
		return new ResponseEntity<> (parentService.getAllParent(), HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Parent> deleteParent(@PathVariable("id") int id){
		parentService.deleteParent(id);
		return new ResponseEntity<> (HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Parent> updateParent(@Validated @RequestBody Parent parent) {
		Parent parent1 = parentService.updateParent(parent);
		if(parent1 == null) new ResponseEntity<> (parent, HttpStatus.CONFLICT);
		return new ResponseEntity<> (parent1, HttpStatus.OK);
	}
	

}
