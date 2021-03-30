package tn.kindergarten.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
	public List<Director> getAllDirector() {
		return (List<Director>) directorrepo.findAll();
}
	@Override
	public Director updateDirector( int id, Director director) {
		Director d = directorrepo.findById(id).get();
		director.setId(d.getId());
		directorrepo.save(director);
		return director;
		
	}


}
