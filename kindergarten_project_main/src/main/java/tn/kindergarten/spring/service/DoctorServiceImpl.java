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
	public void ModifyDoctorById(int docId , Doctor doc) {
		Doctor doctor = docR.findById(docId).get();
		doctor.setAddress(doc.getAddress());
		doctor.setImage(doc.getImage());
		doctor.setEmail(doc.getEmail());
		doctor.setPhonenumber(doc.getPhonenumber());
		doctor.setPassword(doc.getPassword());
		doctor.setName(doc.getName());
		doctor.setLastname(doc.getLastname());
		doctor.setBirthday(doc.getBirthday());
		doctor.setActive(doc.isActive());
		doctor.setDaycare(doc.getDaycare());
		doctor.setRoleA(doc.getRoleA());
		
		
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
		Doctor docctor = docR.findById(docId).get();
		return docctor;
	}

	

}
