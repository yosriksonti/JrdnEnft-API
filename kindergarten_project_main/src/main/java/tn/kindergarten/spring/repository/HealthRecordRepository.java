package tn.kindergarten.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.kindergarten.spring.entities.Child;
import tn.kindergarten.spring.entities.HealthRecord;
import tn.kindergarten.spring.entities.Parent;

@Repository
public interface HealthRecordRepository extends CrudRepository<HealthRecord, Integer> {
	
	
	 @Query("SELECT parents FROM Daycare")
	    public List<Parent> parentList();
	 
	 
	 @Query("SELECT children FROM Parent")
	    public List<Child> childrenlist();
	 

}
