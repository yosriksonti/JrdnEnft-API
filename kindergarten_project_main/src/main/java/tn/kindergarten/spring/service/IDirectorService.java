package tn.kindergarten.spring.service;

import java.util.List;


import tn.kindergarten.spring.entities.Director;
import tn.kindergarten.spring.entities.ProfilAdmin;

public interface IDirectorService {
	public int addDirector(Director director);
	public void updateDirector(Director director , int id);
	public void deleteDirector(int id);
	public List<Director> getAllDirector();
	public Director getDirectorById(int id);

}
