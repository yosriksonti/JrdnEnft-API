package tn.kindergarten.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.kindergarten.spring.entities.Favorite;

public interface FavoriteRepository extends CrudRepository<Favorite, Integer> 
{

}
