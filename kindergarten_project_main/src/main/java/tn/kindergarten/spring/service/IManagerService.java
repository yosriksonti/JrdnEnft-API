package tn.kindergarten.spring.service;


import java.util.List;

import tn.kindergarten.spring.entities.Director;
import tn.kindergarten.spring.entities.Manager;

public interface IManagerService {
	public int addManager(Manager manager);
	public void updateProfileA(Manager manager , int id);
	public void deleteManager(int id);
	public Manager getManagerById(int id);
	public List<Director> getAllDirector();
	

}
