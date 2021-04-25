package tn.kindergarten.spring.service;

import java.util.List;

import tn.kindergarten.spring.entities.Parent;
import tn.kindergarten.spring.entities.Status;

public interface IParentService {
	Parent addParent (Parent parent);
	Parent updateParent (Parent parent);
	void deleteParent (int id);
	List <Parent> getAllParent();
	Parent findParentById(int id);
	Parent findParentByEmail(String email);
	List <Parent> getOrderedByChildren();
	List <Parent> getFiteredByStatus(Status status);
}

