package tn.kindergarten.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.kindergarten.spring.entities.Position;
import tn.kindergarten.spring.service.IPositionService;

@RestController
public class RestPositionController {
	@Autowired
	IPositionService ipositionservice;
	
	
	@PostMapping("/position/add")
	@ResponseBody
	public boolean addPosition(@RequestBody Position position)
	{
		return ipositionservice.addPosition(position);
	}
	
	@PutMapping("/position/{id}/update")
	@ResponseBody
	public boolean ajouterPosition(@RequestBody Position position,@PathVariable("id") int id)
	{
		return ipositionservice.updatePosition(position,id);
		
	}
	
	@DeleteMapping("/position/delete/{id}")
	@ResponseBody
	public int deletePosition(@PathVariable("id") int id )
	{
		ipositionservice.deletePosition(id);
		return id;
	}
	
	@GetMapping("/position/{id}")
	@ResponseBody
	public Position findPosition(@PathVariable("id") int id )
	{
		return ipositionservice.getPositionById(id);
	}

}
