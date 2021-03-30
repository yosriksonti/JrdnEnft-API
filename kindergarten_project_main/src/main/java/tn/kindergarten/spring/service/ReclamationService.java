package tn.kindergarten.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import tn.kindergarten.spring.entities.Daycare;
import tn.kindergarten.spring.entities.Director;
import tn.kindergarten.spring.entities.HealthRecord;
import tn.kindergarten.spring.entities.Reclamation;
<<<<<<< Updated upstream
=======
import tn.kindergarten.spring.entities.TypeReclamation;
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======
	@Autowired
	DaycareServiceImpl daycareService;
>>>>>>> Stashed changes
	
	
	public int addReclamation(Reclamation reclamation) {
		
<<<<<<< Updated upstream
		//reclamationrepo.save(reclamation);
	
		
		Daycare daycare  = daycarerepo.findById(reclamation.getDaycare().getId()).get();
		System.out.println(daycare.getDirector().getId());
		Director director = directorrepository.findById(daycare.getDirector().getId()).get();
		
		sendemailservice.sendEmail(director.getEmail(), reclamation.getParent().getEmail(), reclamation.getDescripRec(), reclamation.getRecName());
		return 1;
=======
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
			sendemailservice.sendEmail( reclamation.getParent().getEmail(),director.getEmail(), reclamation.getDescripRec(), reclamation.getRecName());
			}
		int parentrec = reclamationrepo.findParentBlames(reclamation.getParent().getId());
		if (parentrec>2)
		    { 
			daycareService.removeParent(daycare.getId(),reclamation.getParent().getId());;
			sendemailservice.sendEmail(reclamation.getParent().getEmail(), director.getEmail(), "you have been baned from "+daycare.getDaycareName(), "removal");
		}
	
			return 1;
>>>>>>> Stashed changes
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
