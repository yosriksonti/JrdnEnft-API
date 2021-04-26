package tn.kindergarten.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.spring.entities.Parent;
import tn.kindergarten.spring.entities.Status;
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
	@Override
	public List<Parent> getOrderedByChildren(){
		List<Parent> tab = getAllParent();
		int taille = tab.size();  
        Parent tmp = new Parent();  
        for(int i=0; i < taille; i++) 
        {
                for(int j=1; j < (taille-i); j++)
                {  
                        if(tab.get(j-1).getChildren().size() > tab.get(j).getChildren().size())
                        {
                                tmp = tab.get(j-1);  
                                tab.set(j-1, tab.get(j));  
                                tab.set(j, tmp); 
                        }
 
                }
        }
		
		return tab;
	}
	@Override
	public List<Parent> getFiteredByStatus(Status status){
		List<Parent> allParents = getAllParent();
		List<Parent> parents = new ArrayList<>();
		for(Parent parent : allParents) {
			if(parent.getStatus() == status) {
				parents.add(parent);
			}
		}
		return parents;
	}
	

}