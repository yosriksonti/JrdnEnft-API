
package tn.kindergarten.spring.service;

import java.util.List;

import tn.kindergarten.spring.entities.Doctor;

public interface IDoctorService {
	
	
	public int addDoctor(Doctor doc);
	public void ModifyDoctorById(int docId, Doctor doc);
	public void DeleteDoctorById(int docId);
	public List<Doctor> getAllDoctor();
	public Doctor findDoctor(int docId);
	

}
