package tn.kindergarten.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.spring.entities.Doctor;
import tn.kindergarten.spring.entities.DoctorAvailability;
import tn.kindergarten.spring.repository.DoctorAvaibilityRepository;
import tn.kindergarten.spring.repository.DoctorRepository;

@Service
public class DoctorAvaibilityServiceImpl implements IDoctorAvaibilityService {
	
	
	
	@Autowired
	private DoctorAvaibilityRepository DocAvaiRepo;

	@Override
	public int addDoctorAvaibility(DoctorAvailability docAv ) {
		 DocAvaiRepo.save(docAv);
	
		return docAv.getId();
	}

	@Override
	public void modifyDoctorAvaibility(boolean docav, Date dateBegin, Date dateEnd, int doctorAvaibilityId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDoctorAvaibilityById(int doctorAvaibilityId) {
		// TODO Auto-generated method stub
		DocAvaiRepo.delete(DocAvaiRepo.findById(doctorAvaibilityId).get());
		
	}

	@Override
	public List<DoctorAvailability> getAllDoctorAvaibility() {
		// TODO Auto-generated method stub
		return  (List<DoctorAvailability>) DocAvaiRepo.findAll();
	}
	
	
	
	/*
	@Autowired
	DoctorAvaibilityRepository docA;
	
	@Autowired
	DoctorRepository docR;

	@Override
	public int addDoctorAvaibility(DoctorAvailability docAv) {
		docA.save(docAv);
			
		return docAv.getId();
	}

	@Override
	public void modifyDoctorAvaibility(boolean docavBool, Date dateBegin, Date dateEnd, int doctorAvaibilityId) {
		// TODO Auto-generated method stub
		DoctorAvailability docAV = docA.findById(doctorAvaibilityId).get();
		docAV.setAvailability(docavBool);
		docAV.setBeginwork(dateBegin);
		docAV.setEndwork(dateEnd);
		docA.save(docAV);
		
		
		
	}

	@Override
	public void deleteDoctorAvaibilityById(int doctorAvaibilityId) {
		// TODO Auto-generated method stub
		DoctorAvailability docAV = docA.findById(doctorAvaibilityId).get();
		docA.delete(docAV);
		
		
		
	}


	*/
	
}
