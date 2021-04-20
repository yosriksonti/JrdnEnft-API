package tn.kindergarten.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.kindergarten.spring.entities.Daycare;

@Repository
public interface DaycareRepository extends CrudRepository<Daycare, Integer> 
{
	@Query(value ="select *  from Daycare  LIMIT 3",nativeQuery = true)
    public List<Daycare> getThree();
}
