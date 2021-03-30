package tn.kindergarten.spring.service;

import java.util.List;

import tn.kindergarten.spring.entities.Daycare;
import tn.kindergarten.spring.entities.Favorite;

public interface IDaycareService {
	
	boolean addDaycare(Daycare daycare);
	boolean deleteDaycare(int id);
	boolean updateDaycare(Daycare daycare);
	Daycare findById(int id);
	List<Daycare> findAll();
    int affecterDaycareFavoritee(Favorite favorite) ;

}