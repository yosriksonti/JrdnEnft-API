package tn.kindergarten.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.kindergarten.spring.entities.DoctorAvailability;
@Repository
public interface DoctorAvaibilityRepository extends CrudRepository<DoctorAvailability, Integer>{
	
	@Query("select DISTINCT c from DoctorAvailability c where c.doc.id=:id")
	List<DoctorAvailability> findAllTimeslotbyDoctor(@Param("id")int id);

}
