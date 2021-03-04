package tn.kindergarten.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.spring.entities.Doctor;

import tn.kindergarten.spring.repository.DoctorAvaibilityRepository;
import tn.kindergarten.spring.repository.DoctorRepository;
import tn.kindergarten.spring.repository.HealthRecordRepository;

@Service
public class DoctorServiceImpl implements IDoctorService{
	
	
	@Autowired
	DoctorAvaibilityRepository docA;
	
	@Autowired
	DoctorRepository docR;
	
	@Autowired
	HealthRecordRepository healthR;

	@Override
	public int addDoctor(Doctor doc) {
		docR.save(doc);
		return doc.getId();
	}

	@Override
	public void ModifyDoctorById(int docId , int phonenumber, String email, String address, String password,
			String image) {
		Doctor doctor = docR.findById(docId).get();
		doctor.setAddress(address);
		doctor.setImage(image);
		doctor.setEmail(email);
		doctor.setPhonenumber(phonenumber);
		doctor.setPassword(password);
		
		docR.save(doctor);
		
	}

	@Override
	public void DeleteDoctorById(int docId) {
		Doctor doctor = docR.findById(docId).get();
		docR.delete(doctor);
		
		
	}

	@Override
	public List<Doctor> getAllDoctor() {
		// TODO Auto-generated method stub
		return (List<Doctor>) docR.findAll();
	}

	@Override
	public Doctor findDoctor(int docId) {
		Doctor doctor = docR.findById(docId).get();
		return doctor;
	}

	

}
