package tn.kindergarten.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.spring.entities.Manager;
import tn.kindergarten.spring.entities.FileDB;
import tn.kindergarten.spring.entities.ProfilAdmin;
import tn.kindergarten.spring.repository.ManagerRepository;
import tn.kindergarten.spring.repository.FileDBRepository;
import tn.kindergarten.spring.repository.ManagerRepository;

@Service 
public class ManagerService implements IManagerService {
	@Autowired
	ManagerRepository managerrepo;
	@Autowired
	ManagerRepository profiladminrepository ;
	@Autowired
	FileDBRepository filedbrepository;
	
	 
	public int addManager(Manager manager,String idfiledb) {
		managerrepo.save(manager);
		
		FileDB product2 =filedbrepository.findById(idfiledb).get();
		managerrepo.save(manager);
		return manager.getId();
	}
	public void deleteManager ( int profilid ) {
		managerrepo.delete(managerrepo.findById(profilid).get());
	}
	public Manager getManagerById(int profilid) {
		return managerrepo.findById(profilid).get();
		
	}
	@Override
	public void updateManager(Manager manager, int id) {
		// TODO Auto-generated method stub
		
	}
	public List<Manager> getAll() {
		return (List<Manager>) managerrepo.findAll();
		
	}


}
