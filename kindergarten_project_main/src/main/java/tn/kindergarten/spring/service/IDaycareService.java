package tn.kindergarten.spring.service;

import tn.kindergarten.spring.entities.Favorite;

	
import java.util.List;
<<<<<<< Updated upstream
=======
import java.util.Map;
>>>>>>> Stashed changes

import tn.kindergarten.spring.entities.Daycare;

public interface IDaycareService {
	
	boolean addDaycare(Daycare daycare);
	boolean deleteDaycare(int id);
	boolean updateDaycare(Daycare daycare);
	Daycare findById(int id);
	List<Daycare> findAll();
    int affecterDaycareFavoritee(Favorite favorite) ;
<<<<<<< Updated upstream

=======
    public Map<String,Double> getStatic ();
    
>>>>>>> Stashed changes
}
