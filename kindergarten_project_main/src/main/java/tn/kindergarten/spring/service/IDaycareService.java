package tn.kindergarten.spring.service;

import tn.kindergarten.spring.entities.Favorite;

	
import java.util.List;
import java.util.Map;

import tn.kindergarten.spring.entities.Daycare;

public interface IDaycareService {
	
	boolean addDaycare(Daycare daycare);
	boolean deleteDaycare(int id);
	boolean updateDaycare(Daycare daycare);
	Daycare findById(int id);
	List<Daycare> findAll();
    int affecterDaycareFavoritee(Favorite favorite) ;
    public Map<Integer,Double> getStatic ();
    
}
