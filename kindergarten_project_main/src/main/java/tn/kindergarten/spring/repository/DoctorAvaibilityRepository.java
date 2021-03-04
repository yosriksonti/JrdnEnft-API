package tn.kindergarten.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.kindergarten.spring.entities.DoctorAvailability;
@Repository
public interface DoctorAvaibilityRepository extends CrudRepository<DoctorAvailability, Integer>{

}
