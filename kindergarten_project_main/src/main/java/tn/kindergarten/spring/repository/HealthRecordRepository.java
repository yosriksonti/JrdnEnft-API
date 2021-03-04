package tn.kindergarten.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.kindergarten.spring.entities.HealthRecord;

@Repository
public interface HealthRecordRepository extends CrudRepository<HealthRecord, Integer> {

}
