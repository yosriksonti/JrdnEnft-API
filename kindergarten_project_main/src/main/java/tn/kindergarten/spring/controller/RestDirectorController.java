package tn.kindergarten.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.kindergarten.spring.entities.Director;
import tn.kindergarten.spring.service.IDirectorService;

@RestController
public class RestDirectorController {
	@Autowired
	IDirectorService idirectorservice;
	
	@PostMapping("/addDirector")
	@ResponseBody
	public Director ajouterDirector(@RequestBody Director director)
	{
		idirectorservice.addDirector(director);
		return director;
	}
	
	@DeleteMapping("/deleteDirector/{id}")
	@ResponseBody
	public int deleteDirector(@PathVariable("id") int id )
	{
		idirectorservice.deleteDirector(id);
		return id;
	}
	
	@GetMapping("/Director/{id}")
	@ResponseBody
	public Director findDirector(@PathVariable("id") int id )
	{
		return idirectorservice.getDirectorById(id);
	}
	
	
	@GetMapping("/AllDirector")
	@ResponseBody
	public Director getAll(@PathVariable("id") int id )
	{
		return idirectorservice.getDirectorById(id);
	}
}
