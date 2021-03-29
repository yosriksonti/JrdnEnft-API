package tn.kindergarten.spring.service;

import java.util.List;

import tn.kindergarten.spring.entities.Director;
import tn.kindergarten.spring.entities.Reclamation;

public interface IReclamationService {
	public int addReclamation(Reclamation reclamation);
	
	public List<Reclamation> getAll ( );
	public List<Reclamation> getReclamationByDaycareId(int id);
	public List<Reclamation> getRecByParentId(int id );
	public Reclamation getRecById (int id);
	


}
