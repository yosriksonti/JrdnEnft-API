package tn.kindergarten.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.kindergarten.spring.entities.Visitor;

public interface VisitorRepository extends CrudRepository<Visitor, Integer>
{

}
