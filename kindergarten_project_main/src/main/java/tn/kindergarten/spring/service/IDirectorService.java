package tn.kindergarten.spring.service;

import java.util.List;

import tn.kindergarten.spring.entities.Daycare;
import tn.kindergarten.spring.entities.Director;
import tn.kindergarten.spring.entities.Doctor;
import tn.kindergarten.spring.entities.ProfilAdmin;

public interface IDirectorService {
	public int addDirector(Director dir );
	public void updateDirectorById(int dirId , int phonenumber, String email, String address, String password,
			String image);
	public void deleteDirector(int id);
	public Director getDirectorById(int id);
	public List<Director> getAllDirector();
	public List<Daycare> getDirectorByDaycareId(int id) ;

}
