package tn.kindergarten.spring.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import tn.kindergarten.spring.entities.Response;
import tn.kindergarten.spring.repository.DoctorAvaibilityRepository;
import tn.kindergarten.spring.entities.AgendaDoctorDay;
import tn.kindergarten.spring.entities.AppoitementDoc;
import tn.kindergarten.spring.entities.Doctor;
import tn.kindergarten.spring.entities.DoctorAvailability;
import tn.kindergarten.spring.entities.Parent;
import tn.kindergarten.spring.service.AvaibilityAppoitementService;
import tn.kindergarten.spring.service.IDoctorService;
import tn.kindergarten.spring.service.IParentService;
import tn.kindergarten.spring.service.Service;
import tn.kindergarten.spring.service.SmsRequest;

@RestController
public class AppoitmentDocController {
	
	@Autowired AvaibilityAppoitementService AvaibilityAppService;
	@Autowired IDoctorService DoctorService;
	@Autowired IParentService ParentService;
	@Autowired DoctorAvaibilityRepository docAvaiRepo;

	private List<String> messages;

	
	/*
	 * local methode
	*
	*/
	
	 private final Service service;
	
	 @Autowired
	    public AppoitmentDocController(Service service) {
	        this.service = service;
	    }
	private Response<Doctor> getDoctor(int id) {
		// get doctor
		Doctor doc = null;
		List<String> messages = new ArrayList<String>();
		
		try {
			doc = DoctorService.findDoctor(id);
		} catch (Exception e) {
			// TODO: handle exception
			messages.add("Doctor" +e.getMessage());
			return new Response<Doctor>(-1, messages, null);
			
		}
			
		// doctor  not found ?
		if (doc == null) {
		
			messages.add(String.format("doctor of id [%s] not found", id));
			return new Response<Doctor>(2, messages, null);
		}
		// ok
		return new Response<Doctor>(0, null, doc);
	}
	
	
	private Response<Parent> getParent(int id) {
		// get parent
		Parent parent = null;
		List<String> messages = new ArrayList<String>();
	
		try {
			parent = ParentService.findParentById(id);
		} catch (Exception e) {
			// TODO: handle exception
			messages.add("parent "+e.getMessage());
			return new Response<Parent>(-1, messages, null);
		}
	
		
		
		// parent not found ?
		if (parent == null) {
			
			messages.add(String.format("Le parent d'id [%s] n'existe pas", id));
			return new Response<Parent>(2, messages, null);
		}
		// ok
		return new Response<Parent>(0, null, parent);
	}
	
	
	
	
	private Response<AppoitementDoc> getApp(int id) {
		// get appoitement
		AppoitementDoc rv = null;
		List<String> messages = new ArrayList<String>();
		
		try {
			rv = AvaibilityAppService.findAppById(id);
		} catch (Exception e) {
			// TODO: handle exception
			messages.add("Appoitement "+e.getMessage());
			return new Response<AppoitementDoc>(-1, messages, null);
			
		}
		
		
		// appoitement not found ?
		if (rv == null) {
		
			messages.add(String.format("the appoitement  fo id [%s] not found", id));
			return new Response<AppoitementDoc>(2, messages, null);
		}
		// ok
		return new Response<AppoitementDoc>(0, null, rv);
	}
	
	
	
	
	private Response<DoctorAvailability> getAvailability(int id) {
		// get DoctorAvailability
		DoctorAvailability availability = null;
		List<String> messages = new ArrayList<String>();
		
		try {
			
			availability = AvaibilityAppService.findTimeslotById(id);
		} catch (Exception e) {
			// TODO: handle exception
			messages.add("docotor avaibility" +e.getMessage());
			
			return new Response<DoctorAvailability>(-1, messages, null);
		}
		
		// DoctorAvailability not found ?
		if (availability == null) {
			
			messages.add(String.format("the Doctor Availability of id [%s] not found", id));
			return new Response<DoctorAvailability>(2, messages, null);
		}
		// ok
		return new Response<DoctorAvailability>(0, null, availability);
	}
	

	
	@RequestMapping(value = "/getAllCreneaux/{iddoc}")
	public Response<List<DoctorAvailability>> getAllCreneaux(@PathVariable("iddoc") int idoc) {	
		// we get the doctor
		Response<Doctor> responseDoc = getDoctor(idoc);
		if (responseDoc.getStatus() != 0) {
			return new Response<List<DoctorAvailability>>(responseDoc.getStatus(), responseDoc.getMessages(), null);
		}
		Doctor doctor = responseDoc.getBody();
		// avaibilities of doctor
		List<DoctorAvailability> avaibilities = null;
		try {
			avaibilities = docAvaiRepo.findAllTimeslotbyDoctor(doctor.getId());
			System.out.println(avaibilities);
		} catch (Exception e) {
			// TODO: handle exception
			messages.add(e.getMessage());
			return new Response<List<DoctorAvailability>>(-1, messages, null);
		}
		if (avaibilities != null)
		{
			//return doc avaibility
			List<String> messages = new ArrayList<String>();
			messages.add(String.format("list of avaibility doc = " ,idoc));
			return new Response<List<DoctorAvailability>>(0, messages, avaibilities);
		}
		List<String> messages = new ArrayList<String>();
		messages.add(String.format("the doctor avaibility of id [%s] is empty" ,idoc));
		return new Response<List<DoctorAvailability>>(2, messages, null);
	
	}
	
	/*
	 * *
	 * 
	 * REST 
	 * 
	 */

	@RequestMapping(value = "/getRvMedecinJour/{idDoctor}/{day}")
	public Response<List<AppoitementDoc>> getRvMedecinJour(@PathVariable("idDoctor") int idDoctor,
			@PathVariable("day") String day) {
		// date verification
		Date jourAgenda = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		try {
			jourAgenda = sdf.parse(day);
		} catch (ParseException e) {
			List<String> messages = new ArrayList<String>();
			messages.add(String.format("La date [%s] est invalide", day));
			return new Response<List<AppoitementDoc>>(3, messages, null);
		}
		// we get the doctor
		Response<Doctor> responseDoc = getDoctor(idDoctor);
		if (responseDoc.getStatus() != 0) {
			return new Response<List<AppoitementDoc>>(responseDoc.getStatus(), responseDoc.getMessages(), null);
		}
		Doctor médecin = responseDoc.getBody();
		// liste of appoitement
		List<AppoitementDoc> rvs = null;
		try {
			rvs = AvaibilityAppService.findAppointmentsByDoctorByDay(médecin.getId(), jourAgenda);
		} catch (Exception e1) {
			List<String> messages = new ArrayList<String>();
			messages.add(e1.toString());
			return new Response<List<AppoitementDoc>>(4,messages, null);
		}
		// on rend la réponse

		return new Response<List<AppoitementDoc>>(0, null, rvs);
	}
	
	
	@RequestMapping(value = "/getRvById/{id}" , method = RequestMethod.GET )
	public Response<AppoitementDoc> getRvById(@PathVariable("id") int id) {
	
		AppoitementDoc appdoc = null ;
		List<String> messages = new ArrayList<String>();
		
		try {
			appdoc = AvaibilityAppService.findAppById(id);
		} catch (Exception e) {
			// TODO: handle exception
	
			messages.add("appoitement =" +e.getMessage());
			return new Response<AppoitementDoc>(6, messages, null);
		}
		
		return new Response<AppoitementDoc>(0,messages,appdoc);
		
	}
	
	
	@RequestMapping(value = "/getCreneauById/{id}", method = RequestMethod.GET)
	public Response<DoctorAvailability> getAvaibilityById(@PathVariable("id") int id)
	{
		return getAvailability(id);
	}
	
	
	@RequestMapping(value = "/getAgenda/{id}/{day}", method = RequestMethod.GET)
	public Response<AgendaDoctorDay> getAgenda(@PathVariable("id") int id ,@PathVariable("day") String day) 
	{
		Date jourAgenda = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		try {
			jourAgenda = sdf.parse(day);
		} catch (ParseException e) {
			List<String> messages = new ArrayList<String>();
			messages.add(String.format("the date [%s] is not valid", day));
			return new Response<AgendaDoctorDay>(6, messages, null);
		}
		
		Response<Doctor> responseDoc = getDoctor(id);
		if (responseDoc.getStatus() != 0) {
			return new Response<AgendaDoctorDay>(responseDoc.getStatus(), responseDoc.getMessages(), null);
		}
		
		AgendaDoctorDay ADD = null;
		ADD=AvaibilityAppService.getAgendaDoctorDay(id, jourAgenda);
		
		
		return new Response<AgendaDoctorDay>(0, messages, ADD);
	}
	
	@RequestMapping(value = "/confirmeRv/{id}" ,method = RequestMethod.PUT)
	public Response<AppoitementDoc> confirmRv(@PathVariable("id") int idapp){
		
		AppoitementDoc appdoc=null;
		List<String> messages = new ArrayList<String>();
		try {
			appdoc = AvaibilityAppService.findAppById(idapp);
		} catch (Exception e) {
			// TODO: handle exception
	
			messages.add("appoitement =" +e.getMessage());
			return new Response<AppoitementDoc>(6, messages, null);
		}
		AvaibilityAppService.confirmAppoitement(appdoc);
		
		String phone = appdoc.getParent().getPhoneNumber();
		System.out.println("******************************************");
		System.out.println(phone);
		String msg =("your appoitement of the doctor "+appdoc.getAvailability().getDoc().getName() +" is confirmed");
		
		
		SmsRequest smsRequest = new SmsRequest(phone, msg);
		
		try {
			service.sendSms(smsRequest);
		} catch (Exception e) {
			// TODO: handle exception
			messages.add(e.getMessage());
			return new Response<AppoitementDoc>(6, messages, null);
		}

		return new Response<AppoitementDoc>(0, null, appdoc);
	}
	
	@RequestMapping(value = "/ajouterRv/{day}/{idDocAvaib}/{idParent}" ,method = RequestMethod.POST)
	public Response<Boolean> ajouterRv(@PathVariable("day") String day,@PathVariable("idDocAvaib") int idDoctoravai,@PathVariable("idParent") int idParent) {
		// date verification
		Date jourAgenda = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		try {
			jourAgenda = sdf.parse(day);
		} catch (ParseException e) {
			List<String> messages = new ArrayList<String>();
			messages.add(String.format("the date [%s] is not valid", day));
			return new Response<Boolean>(6, messages, null);
		}
		// we get the avaibility
		Response<DoctorAvailability> responseAvaiblity = getAvailability(idDoctoravai);
		if (responseAvaiblity.getStatus() != 0) {
			return new Response<Boolean>(responseAvaiblity.getStatus(), responseAvaiblity.getMessages(), null);
		}
		DoctorAvailability créneau = responseAvaiblity.getBody();
		// we get the parent
		Response<Parent> responseParent = getParent(idParent);
		if (responseParent.getStatus() != 0) {
			return new Response<Boolean>(responseParent.getStatus() + 2, responseParent.getMessages(), null);
		}
		Parent parent = responseParent.getBody();
		// we add the appoitement
		boolean rv =false;
		try {
			 rv =AvaibilityAppService.createApp(créneau, jourAgenda, parent);
		} catch (Exception e) {
			// TODO: handle exception
			
			return new Response<Boolean>(6,messages , rv);
		}
		
			
		return new Response<Boolean>(0, messages, rv);
	}
	
	
	@DeleteMapping(value = "/supprimerRv/{id}")
	public Response<Void> supprimerRv(@PathVariable("id") int id ) {
		
		Response<AppoitementDoc> responseRv = getApp(id);
		if (responseRv.getStatus() != 0) {
			return new Response<Void>(responseRv.getStatus(), responseRv.getMessages(), null);
		}
		
		AvaibilityAppService.deleteApp(id);
		// ok
		return new Response<Void>(0, null, null);
	}
	
	
	//agenda of doctor of a day 
	
	
	
	
	
	
	
	
	

}
