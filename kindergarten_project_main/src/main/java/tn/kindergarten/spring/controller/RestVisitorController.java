package tn.kindergarten.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.kindergarten.spring.entities.Daycare;
import tn.kindergarten.spring.entities.Director;
import tn.kindergarten.spring.entities.Visitor;
import tn.kindergarten.spring.service.IVisitorService;
@RestController
public class RestVisitorController 

{

	@Autowired
	IVisitorService ivisitorService ;
	
	@PostMapping("/addVisitor/{idfiledb}")
	@ResponseBody
	public Visitor addVisitor(@RequestBody Visitor visitor,@PathVariable (value ="idfiledb") String idfiledb)
	{
		ivisitorService.addVisitorr(visitor,idfiledb);
		return visitor;
	}
	
	@PostMapping("/visitor/closestDaycares")
	@ResponseBody
	public List<Daycare> getClosestDaycares(@RequestBody Visitor visitor)
	{
		return ivisitorService.getClosest(visitor);
	}
	
	
	
		
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
		
		@PostMapping("/visitor/daycares ")
		@ResponseBody
		public List<Daycare> getDaycares(@RequestBody Visitor visitor)
		{
			return ivisitorService.getDaycaresForVisitor(visitor);
		}
		
	
		
}
