package tn.kindergarten.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.kindergarten.spring.entities.Position;


public interface PositionRepository  extends CrudRepository<Position, Integer>
{

}