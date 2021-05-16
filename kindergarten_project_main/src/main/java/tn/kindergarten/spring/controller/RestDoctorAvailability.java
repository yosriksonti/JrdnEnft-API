package tn.kindergarten.spring.controller;

import java.util.ArrayList;
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

import tn.kindergarten.spring.entities.AppoitementDoc;
import tn.kindergarten.spring.entities.Doctor;
import tn.kindergarten.spring.entities.DoctorAvailability;
import tn.kindergarten.spring.entities.HealthRecord;
import tn.kindergarten.spring.entities.Parent;
import tn.kindergarten.spring.entities.Response;
import tn.kindergarten.spring.repository.DoctorAvaibilityRepository;
import tn.kindergarten.spring.service.IDoctorAvaibilityService;
import tn.kindergarten.spring.service.IDoctorService;

@RestController
public class RestDoctorAvailability {
	
	@Autowired 
	IDoctorAvaibilityService IDoctorAvaibilityService;
	
	@Autowired
	DoctorAvaibilityRepository DocAvaiRepo;
	
	@Autowired 
	IDoctorService IDoctor;
	
	
	
	@PostMapping("/addDoctorAvaibility")
	@ResponseBody
	public Response<DoctorAvailability> ajouterDoctorAvaibility(@RequestBody DoctorAvailability docAv)
	{	
		DoctorAvailability DocAvaSave= new DoctorAvailability();
		
		DocAvaSave.setHdebut(docAv.getHdebut());
		DocAvaSave.setHfin(docAv.getHfin());
		DocAvaSave.setMdebut(docAv.getMdebut());
		DocAvaSave.setMfin(docAv.getMfin());
		DocAvaSave.setDoctor(docAv.getDoc());
		
		
		
		
		
		
		
		
		Doctor doc = null;
		try {
		 doc = IDoctor.findDoctor(docAv.getDoc().getId());
		 System.out.println(doc.toString());
		}
		catch (Exception e) {
			e.getMessage();
			List<String> messages = new ArrayList<String>();
			messages.add("doctor not found , exception message :"+ e.getMessage());
			return new Response<DoctorAvailability>(2,messages, null);
			
		}
	
		IDoctorAvaibilityService.addDoctorAvaibility(DocAvaSave);
		
		
		return new Response<DoctorAvailability>(0, null, docAv);
	}
	
	@DeleteMapping("/deleteDoctorAvaibilityById/{id}")
	@ResponseBody
	public Response<DoctorAvailability> deleteDoctorAvaibilityById(@PathVariable("id") int id )
	{
		List<String> messages = new ArrayList<String>();
		try {
			IDoctorAvaibilityService.deleteDoctorAvaibilityById(id);
		} catch (Exception e) {
			// TODO: handle exception
			messages.add("docotor avaibility not found , exception message :" +e.getMessage());
			return new Response<DoctorAvailability>(-1, messages, null);
		}
		messages.add("deleted successfully");
		return new Response<DoctorAvailability>(0, messages, null);
	}
	
	@PutMapping(value = "/modifyDoctorAvaibility/{id}/{docavBool}/{dateBegin}/{dateEnd}")
	@ResponseBody
	public void modifyDoctorAvaibility(@PathVariable("id") int id ,@PathVariable("docavBool") Boolean docavBool ,@PathVariable("dateBegin") Date dateBegin ,@PathVariable("dateEnd") Date dateEnd )
	{
		IDoctorAvaibilityService.modifyDoctorAvaibility(docavBool, dateBegin, dateEnd, id);
	}
	
	
	
	@GetMapping(value = "/getAllDoctorAvaibility")
    @ResponseBody
	public List<DoctorAvailability> getAllDoctorAvaibility() {
		
	
		 return IDoctorAvaibilityService.getAllDoctorAvaibility();
	}
	
	
	
	

	

		
	

}
