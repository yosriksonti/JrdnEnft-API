package tn.kindergarten.spring.service;

import java.util.List;

import tn.kindergarten.spring.entities.Manager;
import tn.kindergarten.spring.entities.ProfilAdmin;

public interface IManagerService {
	public int addManager(Manager manager,String idfiledb );
	public void updateManager(Manager manager , int id);
	public void deleteManager(int id);
	public Manager getManagerById(int id);
	public List<Manager> getAll();

}
