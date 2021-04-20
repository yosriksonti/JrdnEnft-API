package tn.kindergarten.spring.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.spring.entities.Appointement;
import tn.kindergarten.spring.entities.Director;
import tn.kindergarten.spring.entities.shifts;
import tn.kindergarten.spring.entities.Evenement;
import tn.kindergarten.spring.entities.Manager;
import tn.kindergarten.spring.entities.Parent;
import tn.kindergarten.spring.repository.AppointementRepository;

@Service
public class AppointementImpl implements IApointementservice {
	@Autowired 
	AppointementRepository appointementRepository;
	public List<Appointement> getAppointementByIdDate(int id ) throws Exception {
		try {
			ZoneId defaultZoneId = ZoneId.systemDefault();
			
			//creating the instance of LocalDate using the day, month, year info
		        LocalDate localDate = LocalDate.now();
		 
		        //local date + atStartOfDay() + default time zone + toInstant() = Date
		        Date date = java.sql.Date.valueOf(localDate);
		        List<Appointement> appointements=appointementRepository.getAppointementByIdDate(id, date);
				System.out.println(appointements.size());

		        return appointements;	
		} catch(Exception ex) {
			throw new Exception(ex);
		}
		
	}
	
	public Appointement getShift(List<Appointement> appointements,int managerid,int parentid) throws Exception
	{  

		try {
		System.out.println(appointements.size());
		Map<Date, List<Appointement>> map  = new HashMap<Date, List<Appointement>>();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		
		//creating the instance of LocalDate using the day, month, year info
	        LocalDate lastDate = LocalDate.now();
	     for(Appointement appointement : appointements  )
		{
			List<Appointement> tmp = map.get(appointement.getDate().toString());
			if(tmp.size() < 2) {
				tmp.add(appointement);
				map.put(Date.valueOf(appointement.getDate().toString()), tmp);
			}
		}
		Appointement firstAvailable = new Appointement();
		boolean found = false;
		
		
		Manager tmpManager = new Manager();
		tmpManager.setId(managerid);
		
		Parent tmpParent = new Parent();
		tmpParent.setId(parentid);
		
		
		
		for (Map.Entry<Date, List<Appointement>> entry : map.entrySet()) {
			if(entry.getValue().size()<2) {
				firstAvailable = new Appointement(entry.getValue().get(0).getDate(),tmpManager,tmpParent,shifts.values()[entry.getValue().size()+1]);
				found = true;
				break;
			}
			lastDate = entry.getKey().toLocalDate();
		}
		if(!found) {
			firstAvailable = new Appointement(Date.from(lastDate.atStartOfDay(defaultZoneId).toInstant()),tmpParent,tmpManager,shifts.values()[0]);
		}
		System.out.println(firstAvailable.getDate());

		return firstAvailable;
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}
	@Override
	public Appointement getFirstShift(int managerid,int parentid) throws Exception {
		try {
			List<Appointement> appointements  = getAppointementByIdDate(managerid );
			Appointement appointement = getShift(appointements, parentid, parentid);
			Manager tmpManager = new Manager();
			tmpManager.setId(managerid);
			
			Parent tmpParent = new Parent();
			tmpParent.setId(parentid);
			
			appointement.setManeger(tmpManager);
			appointement.setParent(tmpParent);
			
			return addAppointement(appointement) ;
		} catch (Exception ex) {
			throw new Exception(ex);
		}
		
	}
	public Appointement addAppointement(Appointement appointement) {
		appointementRepository.save(appointement);
		return appointement;
	}
	
}
