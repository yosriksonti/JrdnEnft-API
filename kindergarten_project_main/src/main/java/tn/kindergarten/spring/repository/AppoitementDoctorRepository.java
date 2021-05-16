package tn.kindergarten.spring.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import tn.kindergarten.spring.entities.AppoitementDoc;

public interface AppoitementDoctorRepository extends CrudRepository<AppoitementDoc, Integer>{
	
	
	@Query(value="select * from appoitement_doc rv , availability da  where rv.id_availability=da.id and da.doc_id=?1 and rv.jour=?2" ,nativeQuery=true)
	List<AppoitementDoc> findAppointmentByDoctorByDay(int idDoc, LocalDate day);
	
	
	@Query(value="select * from appoitement_doc rv , availability da  where rv.id_availability=da.id and da.doc_id=?1 " ,nativeQuery=true)
	List<AppoitementDoc> findAppointmentByDoctor(int idDoc);
}
