package tn.kindergarten.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.kindergarten.spring.entities.Manager;


public interface ManagerRepository extends CrudRepository<Manager, Integer> {

}
