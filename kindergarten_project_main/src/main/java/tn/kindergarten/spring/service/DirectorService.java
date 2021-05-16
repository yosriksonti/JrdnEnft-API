package tn.kindergarten.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.spring.entities.Daycare;
import tn.kindergarten.spring.entities.Director;
import tn.kindergarten.spring.entities.FileDB;
import tn.kindergarten.spring.entities.ProfilAdmin;
import tn.kindergarten.spring.repository.DirectorRepository;
import tn.kindergarten.spring.repository.FileDBRepository;
import tn.kindergarten.spring.repository.ManagerRepository;

@Service 
public class DirectorService implements IDirectorService {
	@Autowired
	DirectorRepository directorrepo;
	@Autowired
	ManagerRepository profiladminrepository ;
	@Autowired
	FileDBRepository filedbrepository;
	@Autowired
	DaycareServiceImpl daycareService;
	
	 
	public int addDirector(Director director,String idfiledb) {
		directorrepo.save(director);
		
		FileDB product2 =filedbrepository.findById(idfiledb).get();
		directorrepo.save(director);
		return director.getId();
	}
	public void deleteDirector ( int profilid ) {
		directorrepo.delete(directorrepo.findById(profilid).get());
	}
	public Director getDirectorById(int profilid) {
		return directorrepo.findById(profilid).get();
		
	}
	@Override
	public void updateDirectorById(int dirId , int phonenumber, String email, String address, String password,
		String image) {
		Director director = directorrepo.findById(dirId).get();
		director.setAddress(address);
		director.setImage(image);
		director.setEmail(email);
		director.setPhonenumber(phonenumber);
		director.setPassword(password);
		
		directorrepo.save(director);
		
	}
	public List<Director> getAll() {
		return (List<Director>) directorrepo.findAll();
		
	}
	
	@Override
	public List<Daycare> getDirectorByDaycareId(int id) {
		List <Daycare> dayc = (List<Daycare>) daycareService.findAll();
		List<Daycare> daycares = new ArrayList<Daycare>(); 
		for ( Daycare daycare : dayc) {
			if ( daycare.getDirector().getId()==id);
			 daycares.add(daycare);
			 
			
			
		}
		return daycares;
	}
	@Override
	public boolean Update(int id, Director Director) {
		Director director = directorrepo.findById(id).get();
		director.setAddress(Director.getAddress());
		director.setEmail(Director.getEmail());
		director.setPhonenumber(Director.getPhonenumber());
		director.setImage(Director.getImage());
		director.setPassword(Director.getPassword());
		directorrepo.save(director);
		return true;
	}


}
