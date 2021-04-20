package tn.kindergarten.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import tn.kindergarten.spring.entities.Daycare;
import tn.kindergarten.spring.entities.Director;
import tn.kindergarten.spring.entities.HealthRecord;
import tn.kindergarten.spring.entities.Parent;
import tn.kindergarten.spring.entities.Reclamation;
import tn.kindergarten.spring.entities.TypeReclamation;
import tn.kindergarten.spring.repository.DaycareRepository;
import tn.kindergarten.spring.repository.DirectorRepository;
import tn.kindergarten.spring.repository.ManagerRepository;
import tn.kindergarten.spring.repository.ParentRepository;
import tn.kindergarten.spring.repository.ReclamationRepository;
@Service
public class ReclamationService implements IReclamationService{
	@Autowired
	DirectorRepository directorrepo;
	@Autowired
	ReclamationRepository reclamationrepo;
	@Autowired
	ParentRepository parentrepo;
	@Autowired
	SendEmailService sendemailservice ;
	@Autowired
	DirectorRepository directorrepository;
	@Autowired 
	DaycareRepository daycarerepo;
	@Autowired
	DaycareServiceImpl daycareService;
	@Autowired
	ParentServiceImpl parentService;
	
	
public Reclamation addReclamation(Reclamation reclamation) {
		
		reclamationrepo.save(reclamation);
	
		TypeReclamation typerec = null ;
		Daycare daycare  = daycarerepo.findById(reclamation.getDaycare().getId()).get();
		System.out.println(daycare.getDaycareName());
		System.out.println(daycare.getDirector().getId());
		Director director = directorrepository.findById(daycare.getDirector().getId()).get();
		if (reclamation.getTypeRec()== typerec.Reclamation) {
		sendemailservice.sendEmail(director.getEmail(), reclamation.getParent().getEmail(), reclamation.getDescripRec(), reclamation.getRecName());
		}
		else if (reclamation.getTypeRec()== typerec.blame) {
			Parent parent = parentrepo.findById(reclamation.getParent().getId()).get();
			sendemailservice.sendEmail( parent.getEmail(),director.getEmail(), reclamation.getDescripRec(), reclamation.getRecName());
			}
		int parentrec = reclamationrepo.findParentBlames(reclamation.getParent().getId());
		if (parentrec>2)
		    { 
			Parent parent = parentrepo.findById(reclamation.getParent().getId()).get();
			parentService.updateIsActive(parent.getId(),false);
			sendemailservice.sendEmail(parent.getEmail(), director.getEmail(), "Your Account has been Diactivated due to having 3 (or more) consecutive Blames.", "Account Diactivated");
		}
	
			return reclamation;
	}
	
	public List<Reclamation> getAll() {
		return (List<Reclamation>)reclamationrepo.findAll();
	}
	@Override
	public List<Reclamation> getReclamationByDaycareId(int id) {
		List <Reclamation> Rec = (List<Reclamation>) reclamationrepo.findAll();
		List<Reclamation> reclamations = new ArrayList<Reclamation>(); 
		for ( Reclamation reclamation : Rec ) {
			if ( reclamation.getDaycare().getId()==id);
			 reclamations.add(reclamation);
			 
			
			
		}
		return reclamations;
	}
	@Override
	public List<Reclamation> getRecByParentId(int id) {
		List <Reclamation> Rec = (List<Reclamation>) reclamationrepo.findAll();
		List<Reclamation> reclamations = new ArrayList<Reclamation>(); 
		for ( Reclamation reclamation : Rec ) {
			if ( reclamation.getParent().getId()==id);
			 reclamations.add(reclamation);
			 
			
			
		}
		return reclamations;
	
	}
	
	@Override
	public Reclamation getRecById(int id) {
		
		return reclamationrepo.findById(id).get();
	}

}
