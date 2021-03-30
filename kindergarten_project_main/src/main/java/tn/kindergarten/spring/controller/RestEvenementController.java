package tn.kindergarten.spring.controller;

import java.io.IOException;
import java.util.List;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tn.kindergarten.spring.entities.Evenement;
import tn.kindergarten.spring.entities.User;
import tn.kindergarten.spring.message.ResponseMessage;
import tn.kindergarten.spring.service.IEventService;

@RestController
public class RestEvenementController {
	
	@Autowired 
	IEventService ieventService;
	

	@Autowired
	private User user;
	
	// http://localhost:8081/SpringMVC/servlet/ajouterEvenement
	@PostMapping(value="/ajouterEvenement/{idfiledb}")

	@ResponseBody
    public  ResponseEntity<ResponseMessage> ajouterEvenemnt(@RequestBody Evenement evenement,@PathVariable (value ="idfiledb") String idfiledb) throws Exception 
	{  String message = "";
	
	user.setEmailAddress("tayssir.khalifa@esprit.tn");  //Receiver's email address
	/*
	 * Here we will call sendEmail() for Sending mail to the sender.
	 */
		try {
		ieventService.ajouterEvent(evenement,idfiledb);
	      

	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	} catch (Exception e) {
	      message = "Could not upload the file: " ;

	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("date must be !"));
	}
}
	
	@PutMapping(value = "/updateEvenement/{idevent}") 
	public void updateNameEvenement(@RequestBody Evenement evenement,@PathVariable("idevent")int eventId)
	{
		ieventService.updateEvenement(evenement, eventId);
	}
	// URL : http://localhost:8081/SpringMVC/servlet/deleteevenementById/2
    @DeleteMapping("/deleteevenementById/{idevent}") 
	@ResponseBody
	public void deleteEvenementById(@PathVariable("idevent")int eventid) {
    	ieventService.deleteEvenementById(eventid);
	}
    
 // URL : http://localhost:8081/SpringMVC/servlet/getEvenementById/1
    @GetMapping(value = "getEvenementById/{idevenement}")
    @ResponseBody
	public Evenement getEvenementById(@PathVariable("idevenement") int idevenement) {
    	Evenement evenement=ieventService.getEvenementById(idevenement);
		return ieventService.getEvenementById(idevenement);
	}
 // URL : http://localhost:8080/SpringMVC/servlet/getAllEvenement
    @GetMapping(value = "getAllEvenement")
    @ResponseBody   
public List<Evenement> getAllEvenement() {
		
		return ieventService.getAllEvents();
	}
    
    
 

}
