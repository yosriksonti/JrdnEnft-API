package tn.kindergarten.spring.service;

import java.util.List;

import tn.kindergarten.spring.entities.Parent;

public interface IParentService {
	Parent addParent (Parent parent);
	Parent updateParent (Parent parent);
	void deleteParent (int id);
	List <Parent> getAllParent();
	Parent findParentById(int id);

}