package tn.kindergarten.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.spring.entities.Candidat;
import tn.kindergarten.spring.entities.Evenement;
import tn.kindergarten.spring.entities.FileDB;
import tn.kindergarten.spring.entities.Manager;
import tn.kindergarten.spring.repository.candidatRepository;

@Service
public class candidatImpl implements Icandidatservice{
	@Autowired
	candidatRepository candidatrepository;
	
	public List<Candidat> getCandidates()
	{
		
		return (List<Candidat>) candidatrepository.findAll(); 
		
	}
	
	public int ajoutercand(Candidat candidat) 
	{
		
		
		candidatrepository.save(candidat);
		return candidat.getId();
		
		
	}
	
}
