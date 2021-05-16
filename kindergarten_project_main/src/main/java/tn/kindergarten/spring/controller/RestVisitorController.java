package tn.kindergarten.spring.controller;

<<<<<<< Updated upstream
=======
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

>>>>>>> Stashed changes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< Updated upstream
import tn.kindergarten.spring.entities.Director;
=======
import tn.kindergarten.spring.entities.Daycare;
>>>>>>> Stashed changes
import tn.kindergarten.spring.entities.Visitor;
import tn.kindergarten.spring.service.IVisitorService;

@RestController
public class RestVisitorController

{

	@Autowired
<<<<<<< Updated upstream
	IVisitorService ivisitorService ;
	
	@PostMapping("/addVisitor")
	@ResponseBody
	public Visitor addVisitor(@RequestBody Visitor visitor)
	{
		ivisitorService.addVisitorr(visitor);
=======
	IVisitorService ivisitorService;

	@PostMapping("/addVisitor/{idfiledb}")
	@ResponseBody
	public Visitor addVisitor(@Validated @RequestBody Visitor visitor, @PathVariable(value = "idfiledb") String idfiledb) {
		ivisitorService.addVisitorr(visitor, idfiledb);
>>>>>>> Stashed changes
		return visitor;
	}

	
<<<<<<< Updated upstream
=======
	@PostMapping("/visitor/closestDaycares")
	@ResponseBody
	public List<Daycare> getClosestDaycares(@RequestBody Visitor visitor) {
		return ivisitorService.getClosest(visitor);
	}
	

	@PutMapping(value = "/updateVisitor/{id}")
	public void updateVisitor(@RequestBody Visitor visitor, @PathVariable("id") int visitorId) {
		ivisitorService.updateVisitor(visitor, visitorId);
	}

	
	@GetMapping(value ="/Visitor/{id}")
	@ResponseBody
	public Visitor findVisitor(@PathVariable("id") int id) {
		return ivisitorService.read(id);
	}
	@GetMapping(value ="/Visitors")
	@ResponseBody
	public List<Visitor> findVisitors() {
		return ivisitorService.readAll();
	}
	

	@DeleteMapping("/deleteVisitor/{id}")
	@ResponseBody
	public int deleteVisitor(@PathVariable("id") int id) {
		ivisitorService.deleteVisitor(id);
		return id;
	}
>>>>>>> Stashed changes
	

	@PostMapping("/visitor/daycares")
	@ResponseBody
	public List<Daycare> getDaycares(@RequestBody Visitor visitor)
	{
		return ivisitorService.getDaycaresForVisitor(visitor);
	}
	
<<<<<<< Updated upstream
		
		@PutMapping(value = "/updateVisitor/{id}") 
		public void updateVisitor(@RequestBody Visitor visitor,@PathVariable("id")int visitorId)
		{
			ivisitorService.updateVisitor(visitor, visitorId);
		}
		
		@GetMapping("/Visitor/{id}")
		@ResponseBody
		public Visitor findVisitor(@PathVariable("id") int id )
		{
			return ivisitorService.read(id);
		}
		
		
		@DeleteMapping("/deleteVisitor/{id}")
		@ResponseBody
		public int deleteVisitor(@PathVariable("id") int id )
		{
			ivisitorService.deleteVisitor(id);
			return id;
		}
		
		
		
=======
>>>>>>> Stashed changes
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}

	
}
