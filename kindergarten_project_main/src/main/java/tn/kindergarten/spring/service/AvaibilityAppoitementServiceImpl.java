package tn.kindergarten.spring.service;

import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;


import tn.kindergarten.spring.entities.AgendaDoctorDay;
import tn.kindergarten.spring.entities.AppoitementDoc;
import tn.kindergarten.spring.entities.DocAvaibilityDay;
import tn.kindergarten.spring.entities.Doctor;
import tn.kindergarten.spring.entities.DoctorAvailability;
import tn.kindergarten.spring.entities.Parent;
import tn.kindergarten.spring.repository.AppoitementDoctorRepository;
import tn.kindergarten.spring.repository.DoctorAvaibilityRepository;
import tn.kindergarten.spring.repository.DoctorRepository;


@org.springframework.stereotype.Service
@Transactional
public class AvaibilityAppoitementServiceImpl implements AvaibilityAppoitementService {
	
	

	//  private final Service service;
	
	 private final Service service;
	@Autowired
	private DoctorRepository docRepo;
	
	@Autowired
	private AppoitementDoctorRepository appRepo;
	
	@Autowired
	private DoctorAvaibilityRepository DocAvaiRepo;

    @Autowired
    public AvaibilityAppoitementServiceImpl(Service service) {
        this.service = service;
    }
	
	
	@Override
	public AppoitementDoc createApp(DoctorAvailability docAvai, Date day, Parent parent) {
		// TODO Auto-generated method stub
		
		AppoitementDoc rv = new AppoitementDoc() ;
		rv.setAvailability(docAvai);
		rv.setDay(day);
		rv.setParent(parent);	
		rv.setConfirmed(false);
		
		appRepo.save(rv);
		return rv;
	}
	
	@Override
	public AppoitementDoc updateApp(AppoitementDoc app) {
		
		return appRepo.save(app);
	}

	@Override
	public void deleteApp(int idApp) {
		appRepo.deleteById(idApp);
		
	}

	@Override
	
	public AppoitementDoc findAppById(int idApp) {
		// TODO Auto-generated method stub
			
		return appRepo.findById(idApp).get();
	}

	@Override

	public List<AppoitementDoc> findAppointmentsByDoctorByDay(int idDoctor, Date day) {
		// TODO Auto-generated method stub
		return appRepo.findAppointmentByDoctorByDay(idDoctor, day);
	}

	@Override
	
	public Long countAllAppointments() {
		// TODO Auto-generated method stub
		return appRepo.count();
	}

	@Override
	public DoctorAvailability createTimeslot(Date jour, DoctorAvailability docAvai, Parent parent) {
	
		return DocAvaiRepo.save(docAvai);
	}

	@Override
	public DoctorAvailability updateTimeslot(DoctorAvailability timeslot) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTimeslot(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	
	public DoctorAvailability findTimeslotById(int id) {
		// TODO Auto-generated method stub
		return DocAvaiRepo.findById(id).get();
	}

	@Override
	
	public List<DoctorAvailability> findAllTimeslotOfDoctor(int idDoctor) {
		// TODO Auto-generated method stub
		//return DocAvaiRepo.findAllTimeslotbyDoctor(idDoctor);
		return null;
	}

	@Override
	
	public AgendaDoctorDay getAgendaDoctorDay(int idDoc, Date day) {
				// get doctor's timeslot list
				List<DoctorAvailability> avaibilityHours = findAllTimeslotOfDoctor(idDoc);
				// get appointment list fo given doctor in given day
				List<AppoitementDoc> reservations = findAppointmentsByDoctorByDay(idDoc, day);
				
				// on crée un dictionnaire à partir des Rv pris
				Map<Integer, AppoitementDoc> hReservations = new Hashtable<Integer, AppoitementDoc>();
				for (AppoitementDoc resa : reservations) {
					hReservations.put(resa.getAvailability().getId(), resa);
				}
				// on crée l'agenda pour le jour demandé
				AgendaDoctorDay agenda = new AgendaDoctorDay();
				
				// le médecin
				Doctor doctor = docRepo.findById(idDoc).get();
				agenda.setDoc(doctor);		
				// le jour
				agenda.setDay(day);
				
				// les créneaux de réservation
				DocAvaibilityDay[] docAvaiblityday = new DocAvaibilityDay[avaibilityHours.size()];
				agenda.setDocAvaiblityday(docAvaiblityday);
				// remplissage des créneaux de réservation
				for (int i = 0; i < avaibilityHours.size(); i++) {
					// ligne i agenda
					docAvaiblityday[i] = new DocAvaibilityDay();
					// créneau horaire
					DoctorAvailability availabiltiy = avaibilityHours.get(i);
					long idCreneau = availabiltiy.getId();
					docAvaiblityday[i].setAvailabiltiy(availabiltiy);
					// le créneau est-il libre ou réservé ?
					if (hReservations.containsKey(idCreneau)) {
						// le créneau est occupé - on note la résa
						AppoitementDoc resa = hReservations.get(idCreneau);
						docAvaiblityday[i].setApp(resa);
					}
				}
				// on rend le résultat
				return agenda;
		
		
	}

	@Override
	public void confirmAppoitement(AppoitementDoc app) {
		// TODO Auto-generated method stub
		
		app.setConfirmed(true);
		String phone = app.getParent().getPhonenumber();
		System.out.println("******************************************");
		System.out.println(phone);
		SmsRequest smsRequest = null;
		smsRequest.setPhoneNumber(phone);
		smsRequest.setMessage("your appoitement of the doctor "+app.getAvailability().getDoc().getName() +"is confirmed");
		
		service.sendSms(smsRequest);
		
		
		
		
	}



}
