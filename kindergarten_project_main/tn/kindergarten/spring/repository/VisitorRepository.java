package tn.kindergarten.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.kindergarten.spring.entities.Visitor;
@Repository
public interface VisitorRepository extends CrudRepository<Visitor, Integer>
{

}
