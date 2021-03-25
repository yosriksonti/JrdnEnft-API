package tn.kindergarten.spring.controller;

import java.util.Date;
import java.util.List;

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

import tn.kindergarten.spring.entities.Doctor;
import tn.kindergarten.spring.entities.DoctorAvailability;
import tn.kindergarten.spring.entities.HealthRecord;
import tn.kindergarten.spring.entities.Parent;
import tn.kindergarten.spring.entities.Response;
import tn.kindergarten.spring.service.IDoctorAvaibilityService;

@RestController
public class RestDoctorAvailability {
	
	@Autowired 
	IDoctorAvaibilityService IDoctorAvaibilityService;
	
	
	
	@PostMapping("/addDoctorAvaibility")
	@ResponseBody
	public DoctorAvailability ajouterHealthRecord(@RequestBody DoctorAvailability docAv)
	{
		IDoctorAvaibilityService.addDoctorAvaibility(docAv);
		return docAv;
	}
	
	@DeleteMapping("/deleteDoctorAvaibilityById/{id}")
	@ResponseBody
	public int deleteHealthRecord(@PathVariable("id") int id )
	{
		IDoctorAvaibilityService.deleteDoctorAvaibilityById(id);
		return id;
	}
	
	@PutMapping(value = "/modifyDoctorAvaibility/{id}/{docavBool}/{dateBegin}/{dateEnd}")
	@ResponseBody
	public void modifyDoctorAvaibility(@PathVariable("id") int id ,@PathVariable("docavBool") Boolean docavBool ,@PathVariable("dateBegin") Date dateBegin ,@PathVariable("dateEnd") Date dateEnd )
	{
		IDoctorAvaibilityService.modifyDoctorAvaibility(docavBool, dateBegin, dateEnd, id);
	}
	
	@GetMapping(value = "/getAllDoctorAvaibility")
    @ResponseBody
	public List<DoctorAvailability> getAllEmployes() {
		
		return IDoctorAvaibilityService.getAllDoctorAvaibility();
	}
	
	
	
	

	

		
	

}
