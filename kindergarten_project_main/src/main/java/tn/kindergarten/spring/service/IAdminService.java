package tn.kindergarten.spring.service;

import tn.kindergarten.spring.entities.Admin;
import tn.kindergarten.spring.entities.ProfilAdmin;

public interface IAdminService {
	public int addAdmin(Admin director,String idfiledb );
	public void updateAdmin(Admin director , int id);
	public void deleteAdmin(int id);
	public Admin getAdminById(int id);

}
