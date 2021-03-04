package tn.kindergarten.spring.service;

import java.util.Date;
import java.util.List;

import tn.kindergarten.spring.entities.DoctorAvailability;

public interface IDoctorAvaibilityService {
	
	public int addDoctorAvaibility(DoctorAvailability docAv);
	public void modifyDoctorAvaibility(boolean docav, Date dateBegin, Date dateEnd, int doctorAvaibilityId);
	public void deleteDoctorAvaibilityById(int doctorAvaibilityId );
	public List<DoctorAvailability> getAllDoctorAvaibility();
	

}
