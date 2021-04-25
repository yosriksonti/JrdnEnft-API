package tn.kindergarten.spring.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tn.kindergarten.spring.entities.Parent;
import tn.kindergarten.spring.entities.Status;
import tn.kindergarten.spring.repository.ParentRepository;

@Service
public class ParentServiceImpl implements IParentService,UserDetailsService {
	
	@Autowired
	ParentRepository parentRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public Parent addParent(Parent parent) {
		parent.setPassword(bcryptEncoder.encode(parent.getPassword()));
		return parentRepository.save(parent);
	}
	
	@Override
	public Parent updateParent(Parent parent) {
		return parentRepository.save(parent);
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
	public Parent findParentByEmail(String email) {
		return parentRepository.findByemail(email);
	}

	@Override
	public List<Parent> getOrderedByChildren() {
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
	public List<Parent> getFiteredByStatus(Status status) {
		List<Parent> allParents = getAllParent();
		List<Parent> parents = new ArrayList<>();
		for(Parent parent : allParents) {
			if(parent.getStatus() == status) {
				parents.add(parent);
			}
		}
		return parents;
	}

	
	

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Parent parent  = parentRepository.findByemail(username);
	return new org.springframework.security.core.userdetails.User(parent.getEmail(), parent.getPassword(),Collections.emptyList());
}

}
