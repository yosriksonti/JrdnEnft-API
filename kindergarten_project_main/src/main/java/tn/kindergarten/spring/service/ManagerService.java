package tn.kindergarten.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.kindergarten.spring.entities.Manager;
import tn.kindergarten.spring.repository.DirectorRepository;
import tn.kindergarten.spring.repository.ManagerRepository;

@Service
public class ManagerService implements IManagerService{
	@Autowired
	ManagerRepository managerrepository;
	@Autowired
	DirectorRepository directorrepository;
	
	public int addManager(Manager manager) {
	managerrepository.save(manager);
		return manager.getId();
	}
	
	public void deleteManager ( int profilid ) {
		managerrepository.delete(managerrepository.findById(profilid).get());
	}
	public Manager getManagerById(int profilid) {
		return managerrepository.findById(profilid).get();
		
		
	}
	public void updateProfileA(Manager manager , int id)
	{
		Manager manager1 = managerrepository.findById(id).get();
		manager1.setName(manager.getName());
		managerrepository.save(manager1);
	}


	
	
	

}
