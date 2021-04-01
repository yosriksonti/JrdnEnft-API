package tn.kindergarten.spring.service;

import java.util.Date;
import java.util.List;


import tn.kindergarten.spring.entities.AgendaDoctorDay;
import tn.kindergarten.spring.entities.AppoitementDoc;
import tn.kindergarten.spring.entities.DoctorAvailability;
import tn.kindergarten.spring.entities.Parent;

public interface AvaibilityAppoitementService {
	
	
	public AppoitementDoc createApp(DoctorAvailability docAvai,Date day,Parent parent );
	public AppoitementDoc updateApp(AppoitementDoc app);
	
	public void deleteApp(int idApp);
	
	
	public void confirmAppoitement (AppoitementDoc app);
	
	public AppoitementDoc findAppById(int idApp);
	public List<AppoitementDoc> findAppointmentsByDoctorByDay (int idDoctor , Date day);
	public Long countAllAppointments();
	
	
	public DoctorAvailability createTimeslot(Date jour, DoctorAvailability docAvai, Parent parent);
	 
	public DoctorAvailability updateTimeslot(DoctorAvailability timeslot);
	public void deleteTimeslot(int id);
	
	public DoctorAvailability findTimeslotById(int id);
	public List<DoctorAvailability> findAllTimeslotOfDoctor(int idDoctor);
	
	public AgendaDoctorDay getAgendaDoctorDay(int idDoc, Date jour);
	
	
	

}
