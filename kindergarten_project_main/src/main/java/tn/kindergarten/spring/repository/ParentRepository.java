package tn.kindergarten.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.kindergarten.spring.entities.Parent;

public interface ParentRepository extends JpaRepository<Parent, Integer>{
	 Parent findByemail(String email);


}
