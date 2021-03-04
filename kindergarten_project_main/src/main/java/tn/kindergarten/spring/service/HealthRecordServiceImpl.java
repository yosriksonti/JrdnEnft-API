package tn.kindergarten.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.spring.entities.HealthRecord;
import tn.kindergarten.spring.repository.DoctorRepository;
import tn.kindergarten.spring.repository.HealthRecordRepository;

@Service
public class HealthRecordServiceImpl implements IHealthRecordService {
	
	@Autowired
	DoctorRepository docR;
	
	@Autowired
	HealthRecordRepository healthR;

	@Override
	public int addHealthRecord(HealthRecord HR) {
		healthR.save(HR);
		return HR.getId();
	}

	@Override
	public void ModifyHealthRecordById(int HealthRecordId , Date AppointDate ,  String description,String etat,String images)
	{
		HealthRecord hre = healthR.findById(HealthRecordId).get();
		hre.setAppointDate(AppointDate);
		hre.setDescription(description);
		hre.setEtat(etat);
		hre.setImages(images);
		healthR.save(hre);
		
	}

	@Override
	public void DeleteHealthRecordById(int HealthRecordId) {
		// TODO Auto-generated method stub
		HealthRecord hre = healthR.findById(HealthRecordId).get();
		healthR.delete(hre);
		
	}

	@Override
	public List<HealthRecord> getAllHealthRecords() {
		// TODO Auto-generated method stub
		return (List<HealthRecord>) healthR.findAll();
	}
	
	
	

}
