package tn.kindergarten.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.kindergarten.spring.entities.Reclamation;

public interface ReclamationRepository extends  CrudRepository<Reclamation, Integer>{
	@Query("select count(r.id)  from Reclamation r where parent_id=:id and r.typeRec='blame'")
    public int findParentBlames(@Param("id")int id);

}
