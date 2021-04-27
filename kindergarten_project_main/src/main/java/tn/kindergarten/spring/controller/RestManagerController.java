package tn.kindergarten.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.kindergarten.spring.entities.Manager;
import tn.kindergarten.spring.service.IManagerService;

@RestController
public class RestManagerController {
	@Autowired
	IManagerService imanagerservice;
	
	
	@PostMapping("/addManager/{idfiledb}")
	@ResponseBody
	public Manager addManager(@RequestBody Manager manager,@PathVariable (value ="idfiledb") String idfiledb)
	{
		imanagerservice.addManager(manager,idfiledb);
		return manager;
	}
	
	/*@PostMapping("/addManager")
	@ResponseBody
	public Manager ajouterManager(@RequestBody Manager manager)
	{
		imanagerservice.addManager(manager);
		return manager;
	}*/
	
	@DeleteMapping("/deleteManager/{id}")
	@ResponseBody
	public int deleteManager(@PathVariable("id") int id )
	{
		imanagerservice.deleteManager(id);
		return id;
	}
	
	@GetMapping("/Manager/{id}")
	@ResponseBody
	public Manager findManager(@PathVariable("id") int id )
	{
		return imanagerservice.getManagerById(id);
	}
	
	@GetMapping("/Managers")
	@ResponseBody
	public List<Manager> findManagers()
	{
		return imanagerservice.getAll();
	}

}
