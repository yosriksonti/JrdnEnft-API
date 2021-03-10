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


import tn.kindergarten.spring.entities.Doctor;
import tn.kindergarten.spring.service.IDoctorService;

@RestController
public class RestDoctorController {
	@Autowired
	IDoctorService iDoctorservice;
	
	@PostMapping("/addDoctor")
	@ResponseBody
	public Doctor ajouterDoctor(@RequestBody Doctor Doctor)
	{
		iDoctorservice.addDoctor(Doctor);
		return Doctor;
	}
	
	@DeleteMapping("/deleteDoctor/{id}")
	@ResponseBody
	public int deleteDoctor(@PathVariable("id") int id )
	{
		iDoctorservice.DeleteDoctorById(id);
		return id;
	}
	
	@GetMapping("/Doctor/{id}")
	@ResponseBody
	public Doctor findDoctor(@PathVariable("id") int id )
	{
		return iDoctorservice.findDoctor(id);
	}
	
	@GetMapping(value = "/getAllDoctors")
    @ResponseBody
	public List<Doctor> getAllEmployes() {
		
		return iDoctorservice.getAllDoctor();
	}

}
