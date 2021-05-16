package tn.kindergarten.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.print.Doc;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.lang.Arrays;
import tn.kindergarten.spring.entities.Doctor;
import tn.kindergarten.spring.entities.DoctorAvailability;
import tn.kindergarten.spring.entities.Response;
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
	
	
	
	
	
	
	@RequestMapping(value = "/getMedecinById/{id}")
	public Response<Doctor> getMedecinById(@PathVariable("id") int id) {
	
	
		// on récupère le médecin
		
		Doctor doc = null;
		
		doc= iDoctorservice.findDoctor(id);
		
		List<String> messages = new ArrayList<String>();
		messages.add(String.format("the doctor  of id [%s] " ,id));
		return new Response<Doctor>(0, messages, doc);
		
				
	}
	
	
	
	
	@GetMapping(value = "/getAllDoctors")
    @ResponseBody
	public List<Doctor> getAllEmployes() {
		
		return iDoctorservice.getAllDoctor();
	}
	
	
	@PutMapping(value = "/ModifyDoctorById/{id}")
	@ResponseBody
	public void ModifyDoctorById(@RequestBody Doctor doc, @PathVariable("id") int id )
	{
		iDoctorservice.ModifyDoctorById(id, doc);
	}
}
