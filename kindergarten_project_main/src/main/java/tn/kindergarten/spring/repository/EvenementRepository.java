package tn.kindergarten.spring.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import tn.kindergarten.spring.entities.Evenement;

public interface EvenementRepository extends CrudRepository<Evenement, Integer>,
PagingAndSortingRepository<Evenement, Integer>,
JpaSpecificationExecutor<Evenement>{

}
