package tn.kindergarten.spring.service;

import java.util.List;

import tn.kindergarten.spring.entities.Daycare;

public interface IDaycareService {
	
	boolean addDaycare(Daycare daycare);
	boolean deleteDaycare(int id);
	boolean updateLogoDaycare(Daycare daycare,int id);
	Daycare findByid(int id);
	List<Daycare> findAll();
}
