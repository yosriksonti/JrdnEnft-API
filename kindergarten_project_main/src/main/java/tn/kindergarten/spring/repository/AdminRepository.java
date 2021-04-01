package tn.kindergarten.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.kindergarten.spring.entities.Admin;


public interface AdminRepository  extends CrudRepository<Admin, Integer>
{

}
