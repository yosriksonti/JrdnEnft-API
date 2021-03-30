package tn.kindergarten.spring.repository;


<<<<<<< Updated upstream
import org.springframework.data.repository.CrudRepository;
=======
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
>>>>>>> Stashed changes

import tn.kindergarten.spring.entities.Reclamation;

public interface ReclamationRepository extends  CrudRepository<Reclamation, Integer>{
<<<<<<< Updated upstream
=======
	@Query("select count(r.id)  from Reclamation r where parent_id=:id and r.typeRec='blame'")
    public int findParentBlames(@Param("id")int id);
>>>>>>> Stashed changes

}
