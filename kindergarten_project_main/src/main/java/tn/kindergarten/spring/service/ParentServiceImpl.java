package tn.kindergarten.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.spring.entities.Parent;
import tn.kindergarten.spring.repository.ParentRepository;

@Service
public class ParentServiceImpl implements IParentService {
	
	@Autowired
	ParentRepository parentRepository;
	
	@Override
	public Parent addParent(Parent parent) {
		return parentRepository.save(parent);
	}
	
	@Override
	public Parent updateParent(Parent parent) {
		return parentRepository.saveAndFlush(parent);
	}
	
	@Override
	public void deleteParent(int id) {
		parentRepository.deleteById(id);
	}
	
	@Override
	public List<Parent> getAllParent() {
		return parentRepository.findAll();
	}
	
	@Override
	public Parent findParentById(int id) {
		return parentRepository.getOne(id);
	}
	

}