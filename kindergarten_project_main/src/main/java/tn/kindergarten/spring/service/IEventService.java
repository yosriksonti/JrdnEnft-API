package tn.kindergarten.spring.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;

import tn.kindergarten.spring.entities.Evenement;

public interface IEventService {
	
	public int ajouterEvent(Evenement evenement,String idfiledb) throws Exception;
	public void deleteEvenementById(int evenementId);
    public Evenement getEvenementById(int id);
    public void updateEvenement(Evenement evenement, int id);
    public Pageable buildPageRequest(HttpHeaders headers, Sort sort);
	 public List<Evenement> getAllEvents();
}
