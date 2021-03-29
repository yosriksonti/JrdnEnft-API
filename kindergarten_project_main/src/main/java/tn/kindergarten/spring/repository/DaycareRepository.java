package tn.kindergarten.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.kindergarten.spring.entities.Daycare;

@Repository
	public interface DaycareRepository extends CrudRepository<Daycare, Integer> 
	{

	}


