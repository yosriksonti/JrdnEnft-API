package tn.kindergarten.spring.service;

import java.util.List;

import tn.kindergarten.spring.entities.Doctor;

public interface IDoctorService {
	
	
	public int addDoctor(Doctor doc);
	public void ModifyDoctorById(int docId, int phonenumber, String email, String address, String password,
			String image);
	public void DeleteDoctorById(int docId);
	public List<Doctor> getAllDoctor();
	;

}
