package tn.kindergarten.spring.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tn.kindergarten.spring.entities.Response;
import tn.kindergarten.spring.entities.AppoitementDoc;
import tn.kindergarten.spring.entities.Doctor;
import tn.kindergarten.spring.entities.DoctorAvailability;
import tn.kindergarten.spring.entities.Parent;
import tn.kindergarten.spring.service.AvaibilityAppoitementService;
import tn.kindergarten.spring.service.IDoctorService;

@RestController
public class AppoitmentDocController {
	
	@Autowired AvaibilityAppoitementService AvaibilityAppService;
	@Autowired IDoctorService DoctorService;

	
	
	private List<String> messages;
	
	
	
	/*
	 * local methode
	*
	*
	*
	*/
	
	
	private Response<Doctor> getDoctor(int id) {
		// get doctor
		Doctor doc = null;
		
			doc = DoctorService.findDoctor(id);
	
		// doctor  not found ?
		if (doc == null) {
			List<String> messages = new ArrayList<String>();
			messages.add(String.format("doctor of id [%s] not found", id));
			return new Response<Doctor>(2, messages, null);
		}
		// ok
		return new Response<Doctor>(0, null, doc);
	}
	
	
	private Response<Parent> getParent(int id) {
		// get parent
		Parent parent = null;
	
		
	
		
		
		// parent not found ?
		if (parent == null) {
			List<String> messages = new ArrayList<String>();
			messages.add(String.format("Le parent d'id [%s] n'existe pas", id));
			return new Response<Parent>(2, messages, null);
		}
		// ok
		return new Response<Parent>(0, null, parent);
	}
	
	
	
	
	private Response<AppoitementDoc> getApp(int id) {
		// get appoitement
		AppoitementDoc rv = null;
	
		// appoitement not found ?
		if (rv == null) {
			List<String> messages = new ArrayList<String>();
			messages.add(String.format("the appoitement  fo id [%s] not found", id));
			return new Response<AppoitementDoc>(2, messages, null);
		}
		// ok
		return new Response<AppoitementDoc>(0, null, rv);
	}
	
	
	
	
	private Response<DoctorAvailability> getAvailability(int id) {
		// get DoctorAvailability
		DoctorAvailability availability = null;
		
		// DoctorAvailability not found ?
		if (availability == null) {
			List<String> messages = new ArrayList<String>();
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
		
		avaibilities = AvaibilityAppService.findAllTimeslotOfDoctor(doctor.getId());
	
		
		if (avaibilities == null)
		{
		List<String> messages = new ArrayList<String>();
			messages.add(String.format("the doctor avaibility of id [%s] is empty" ,idoc));
			return new Response<List<DoctorAvailability>>(2, messages, null);
		}
	//return doc avaibility
		return new Response<List<DoctorAvailability>>(0, null, avaibilities);
	}
	
	

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
	
	
	@RequestMapping(value = "/getRvById/{id}", method = RequestMethod.GET)
	public Response<AppoitementDoc> getRvById(@PathVariable("id") int id) {
	
		
		return getApp(id);
	}
	
	
	@RequestMapping(value = "/getCreneauById/{id}", method = RequestMethod.GET)
	public Response<DoctorAvailability> getAvaibilityById(@PathVariable("id") int id)
	{
		
		DoctorAvailability doctorAvailability = null ;
		doctorAvailability = AvaibilityAppService.findTimeslotById(id);
		
		
		
		return new Response<DoctorAvailability>(0,null , doctorAvailability);
		
		
	}
	
	
	
	
	@PostMapping(value = "/ajouterRv/{day}/{idDocAvaib}/{idParent}")
	public Response<AppoitementDoc> ajouterRv(@PathVariable("day") String day,@PathVariable("idDocAvaib") int idDoctoravai,@PathVariable("idParent") int idParent) {

	
		// on récupère les valeurs postées

	
		
		// date verification
		Date jourAgenda = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		try {
			jourAgenda = sdf.parse(day);
		} catch (ParseException e) {
			List<String> messages = new ArrayList<String>();
			messages.add(String.format("the date [%s] is not valid", day));
			return new Response<AppoitementDoc>(6, messages, null);
		}
		// we get the avaibility
	//	Response<DoctorAvailability> responseAvaiblity = getAvaibilityById(idDoctoravai);
		//if (responseAvaiblity.getStatus() != 0) {
			
			
		//	return new Response<AppoitementDoc>(responseAvaiblity.getStatus(), responseAvaiblity.getMessages(), null);
	//	}
		//DoctorAvailability créneau = responseAvaiblity.getBody();
		// we get the parent
		
		DoctorAvailability  créneau = new DoctorAvailability();
		
		créneau.setDoc(DoctorService.findDoctor(7));
		créneau.setDoctor(7);
		créneau.setId(1);
		créneau.setHdebut(17);
		créneau.setHfin(20);
	
		
	//	Response<Parent> responseParent = getParent(idParent);
	//	if (responseParent.getStatus() != 0) {
		//	return new Response<AppoitementDoc>(responseParent.getStatus() + 2, responseParent.getMessages(), null);
	//	}
		//Parent parent = responseParent.getBody();
		
		Parent parent = new Parent();
		
		parent.setId(1);
	
		
		
		
		
		// we add the appoitement
		AppoitementDoc rv = new AppoitementDoc() ;
		
			rv.setAvailability(créneau);
			rv.setDay(jourAgenda);
			rv.setParent(parent);
			
			AvaibilityAppService.createApp(rv);
	

		return new Response<AppoitementDoc>(0, null, rv);
	}
	
	
	
	
	
	
	
	

}
