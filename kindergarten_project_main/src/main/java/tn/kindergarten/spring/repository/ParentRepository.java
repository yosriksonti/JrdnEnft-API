package tn.kindergarten.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import tn.kindergarten.spring.entities.Parent;

public interface ParentRepository extends JpaRepository<Parent, Integer>{



}
