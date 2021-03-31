package tn.kindergarten.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.kindergarten.spring.entities.Post;

@Repository
public interface PostRepository extends CrudRepository<Post,Integer>{

}
