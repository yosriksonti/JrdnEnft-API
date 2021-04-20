package tn.kindergarten.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import tn.kindergarten.spring.entities.AppoitementDoc;

public interface AppoitementDoctorRepository extends CrudRepository<AppoitementDoc, Integer>{
	
	
	@Query("select rv from AppoitementDoc rv left join fetch rv.parent c left join fetch rv.availability cr where cr.doc.id=?1 and rv.day=?2")
	List<AppoitementDoc> findAppointmentByDoctorByDay(int idDoc, Date day);
}
