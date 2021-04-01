package tn.kindergarten.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.spring.entities.Position;
import tn.kindergarten.spring.entities.FileDB;
import tn.kindergarten.spring.entities.ProfilAdmin;
import tn.kindergarten.spring.repository.PositionRepository;
import tn.kindergarten.spring.repository.FileDBRepository;
import tn.kindergarten.spring.repository.ManagerRepository;

@Service 
public class PositionService implements IPositionService {
	@Autowired
	PositionRepository positionrepo;
	@Autowired
	ManagerRepository profiladminrepository ;
	@Autowired
	FileDBRepository filedbrepository;
	
	 
	public boolean addPosition(Position position) {
		positionrepo.save(position);
		return true;
	}
	public void deletePosition ( int profilid ) {
		positionrepo.delete(positionrepo.findById(profilid).get());
	}
	public Position getPositionById(int profilid) {
		return positionrepo.findById(profilid).get();
		
	}
	@Override
	public boolean updatePosition(Position position, int id) {
		Position psn = getPositionById(id);
		psn.setX(position.getX());
		psn.setY(position.getY());
		positionrepo.save(psn);
		return true;
	}


}
