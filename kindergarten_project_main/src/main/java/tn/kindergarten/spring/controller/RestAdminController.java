package tn.kindergarten.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.kindergarten.spring.entities.Admin;
import tn.kindergarten.spring.service.IAdminService;

@RestController
public class RestAdminController {
	@Autowired
	IAdminService iadminservice;
	
	
	@PostMapping("/addAdmin/{idfiledb}")
	@ResponseBody
	public Admin addAdmin(@RequestBody Admin admin,@PathVariable (value ="idfiledb") String idfiledb)
	{
		iadminservice.addAdmin(admin,idfiledb);
		return admin;
	}
	
	/*@PostMapping("/addAdmin")
	@ResponseBody
	public Admin ajouterAdmin(@RequestBody Admin admin)
	{
		iadminservice.addAdmin(admin);
		return admin;
	}*/
	
	@DeleteMapping("/deleteAdmin/{id}")
	@ResponseBody
	public int deleteAdmin(@PathVariable("id") int id )
	{
		iadminservice.deleteAdmin(id);
		return id;
	}
	
	@GetMapping("/Admin/{id}")
	@ResponseBody
	public Admin findAdmin(@PathVariable("id") int id )
	{
		return iadminservice.getAdminById(id);
	}

}
