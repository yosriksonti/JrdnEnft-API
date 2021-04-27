package tn.kindergarten.spring.service;

import java.util.List;

import tn.kindergarten.spring.entities.Daycare;
import tn.kindergarten.spring.entities.Director;
import tn.kindergarten.spring.entities.ProfilAdmin;

public interface IDirectorService {
	public int addDirector(Director director,String idfiledb );
	public void deleteDirector(int id);
	public Director getDirectorById(int id);
	public List<Director> getAll();
	List<Daycare> getDirectorByDaycareId(int id);
	void updateDirectorById(int dirId, int phonenumber, String email, String address, String password, String image);
	boolean Update(int id, Director Director);

}
