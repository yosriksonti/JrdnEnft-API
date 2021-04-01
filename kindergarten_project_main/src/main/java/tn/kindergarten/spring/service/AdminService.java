package tn.kindergarten.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.spring.entities.Admin;
import tn.kindergarten.spring.entities.FileDB;
import tn.kindergarten.spring.entities.ProfilAdmin;
import tn.kindergarten.spring.repository.AdminRepository;
import tn.kindergarten.spring.repository.FileDBRepository;
import tn.kindergarten.spring.repository.ManagerRepository;

@Service 
public class AdminService implements IAdminService {
	@Autowired
	AdminRepository adminrepo;
	@Autowired
	ManagerRepository profiladminrepository ;
	@Autowired
	FileDBRepository filedbrepository;
	
	 
	public int addAdmin(Admin admin,String idfiledb) {
		adminrepo.save(admin);
		
		FileDB product2 = filedbrepository.findById(idfiledb).get();
		adminrepo.save(admin);
		return admin.getId();
	}
	public void deleteAdmin ( int profilid ) {
		adminrepo.delete(adminrepo.findById(profilid).get());
	}
	public Admin getAdminById(int profilid) {
		return adminrepo.findById(profilid).get();
		
	}
	@Override
	public void updateAdmin(Admin admin, int id) {
		Admin admn = getAdminById(id);
		if(admin.getName() != null) {
		admn.setName(admin.getName());
		}
		adminrepo.save(admn);
		
		
	}


}
