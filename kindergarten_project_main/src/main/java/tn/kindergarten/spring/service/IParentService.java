package tn.kindergarten.spring.service;

import java.util.List;

import tn.kindergarten.spring.entities.Parent;
import tn.kindergarten.spring.entities.Status;

public interface IParentService {
	Parent addParent (Parent parent);
	Parent updateParent (Parent parent);
	void deleteParent (int id);
	List <Parent> getAllParent();
	List <Parent> getOrderedByChildren();
	List <Parent> getFiteredByStatus(Status status);
	Parent findParentById(int id);

	public List<Parent> getAllparents() ;


}
