package tn.kindergarten.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import tn.kindergarten.spring.entities.Evenement;
import tn.kindergarten.spring.entities.FileDB;
import tn.kindergarten.spring.repository.EvenementRepository;
import tn.kindergarten.spring.repository.FileDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
@Service
public class EventServiceImpl implements IEventService {

	@Autowired
	EvenementRepository evenementRepository;
	@Autowired
	FileDBRepository filedbrepository;
	public int ajouterEvent(Evenement evenement,String idfiledb) throws Exception
	{
		try {
			FileDB product2 =filedbrepository.findById(idfiledb).get();
		evenement.setFiledb(product2);
		evenementRepository.save(evenement);
		return evenement.getId();
		
		}catch(Exception ex)
		{
		throw new Exception(ex);
	}}
	
	
	public void deleteEvenementById(int evenementId)
	{
		Evenement evenement = evenementRepository.findById(evenementId).get();


	

		evenementRepository.delete(evenement);
	}
	
	
	public List<Evenement> getAllEvents() {
		return (List<Evenement>) evenementRepository.findAll();
}
	
	@Override
	public void updateEvenement(Evenement evenement,int evenementId,String idfiledb)
	{
		Evenement evenement1 = evenementRepository.findById(evenementId).get();
		FileDB product2 =filedbrepository.findById(idfiledb).get();
		evenement1.setName(evenement.getName());
		evenement1.setAtelier(evenement.getAtelier());
		evenement1.setNbParticipant(evenement.getNbParticipant());
		evenement1.setType(evenement.getType());
		evenement1.setDate(evenement.getDate());
		evenement1.setFiledb(product2);





		evenementRepository.save(evenement1);


	}

	

    public List<Evenement> get(Specification<Evenement> spec, Sort sort) {
        return evenementRepository.findAll(spec, sort);
    }
	@Override
	public Evenement getEvenementById(int id) {
		Evenement evenement = evenementRepository.findById(id).get();
		return evenement;
	}


	@Override
	public Pageable buildPageRequest(HttpHeaders headers, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
