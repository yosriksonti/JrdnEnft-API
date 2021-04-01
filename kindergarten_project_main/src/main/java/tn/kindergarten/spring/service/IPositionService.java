package tn.kindergarten.spring.service;

import tn.kindergarten.spring.entities.Position;
import tn.kindergarten.spring.entities.ProfilAdmin;

public interface IPositionService {
	public boolean addPosition(Position position );
	public boolean updatePosition(Position position , int id);
	public void deletePosition(int id);
	public Position getPositionById(int id);

}
