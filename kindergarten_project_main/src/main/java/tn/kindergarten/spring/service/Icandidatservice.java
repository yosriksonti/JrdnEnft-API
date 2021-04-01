package tn.kindergarten.spring.service;

import java.util.List;

import tn.kindergarten.spring.entities.Candidat;

public interface Icandidatservice {
	public List<Candidat> getCandidates();
	public int ajoutercand(Candidat candidat) ;

}
