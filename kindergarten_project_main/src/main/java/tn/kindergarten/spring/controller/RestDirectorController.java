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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.kindergarten.spring.entities.Director;
import tn.kindergarten.spring.entities.Parent;
import tn.kindergarten.spring.service.IDirectorService;

@RestController
public class RestDirectorController {
	@Autowired
	IDirectorService idirectorservice;
	
	
	@PostMapping("/addVisitor/{idfiledb}")
	@ResponseBody
	public Director addDirector(@RequestBody Director director,@PathVariable (value ="idfiledb") String idfiledb)
	{
		idirectorservice.addDirector(director,idfiledb);
		return director;
	}
	
	/*@PostMapping("/addDirector")
	@ResponseBody
	public Director ajouterDirector(@RequestBody Director director)
	{
		idirectorservice.addDirector(director);
		return director;
	}*/
	
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
<<<<<<< Updated upstream
	@GetMapping(value = "/getAllDirector")
    @ResponseBody
	public List<Director> getAllDirector() {
		
		return idirectorservice.getAllDirector();
	}

=======
	@PutMapping("/update/{id}")
	public ResponseEntity<Director> updateDirector(@Validated @RequestBody Director director, @PathVariable("id") int  id  ) {
		Director director1 = idirectorservice.updateDirector( id, director);
		if(director1 == null) new ResponseEntity<> (director, HttpStatus.CONFLICT);
		return new ResponseEntity<> ( HttpStatus.OK);
	}
>>>>>>> Stashed changes

}
