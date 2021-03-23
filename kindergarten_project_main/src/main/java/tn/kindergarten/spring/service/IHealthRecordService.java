package tn.kindergarten.spring.service;

import java.util.Date;
import java.util.List;

import tn.kindergarten.spring.entities.HealthRecord;
import tn.kindergarten.spring.entities.Parent;

public interface IHealthRecordService {
	
	public int addHealthRecord(HealthRecord HR);
	public void ModifyHealthRecordById(int HealthRecordId , Date AppointDate ,  String description,String etat,String images);
	public void DeleteHealthRecordById(int HealthRecordId);
	public List<HealthRecord> getAllHealthRecords() ;
	public HealthRecord findHealthRecord(int HealthRecordId);
	
	public List<Parent> getAllParentsJPQL();
	

}
