package tn.kindergarten.spring.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import tn.kindergarten.spring.entities.Vote;
import tn.kindergarten.spring.entities.VoteCount;


public interface VoterRepository extends CrudRepository<Vote,Integer>{

	//@Query("SELECT  v.id,v.candidate,v.election from Vote v ")
    //public  List<VoteCount> getResults() ;

	
	@Query("SELECT count(*) FROM Vote")
    public int countvote();
	
	
	@Query("SELECT DISTINCT v.candidate "
			+" from Vote v "
			+"GROUP BY v.candidate "
			+"ORDER BY COUNT (v.election) DESC  ")
    public  List<VoteCount> getWinner(@PathVariable("election") String election) ;

}
