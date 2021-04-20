package tn.kindergarten.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.kindergarten.spring.entities.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

}
