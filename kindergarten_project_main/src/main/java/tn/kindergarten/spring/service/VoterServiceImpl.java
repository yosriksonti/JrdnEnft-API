package tn.kindergarten.spring.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.kindergarten.spring.entities.Candidat;
import tn.kindergarten.spring.entities.Vote;
import tn.kindergarten.spring.repository.VoterRepository;


@Service
public class VoterServiceImpl implements IVoterService{
	@Autowired
	Icandidatservice icandidatservice;
	@Autowired
	VoterRepository voterrepository;
    private List<Vote> votes = new ArrayList<>();
    
    public List<Vote> getVotes() {
        return votes;
    }

    
 // accepts map of candidates and total votes
    public void votesFromMap(Map<String, String> candidates, String election) {
        votes.clear(); // clear previous seed data from list
        for (Map.Entry<String, String> entry : candidates.entrySet()) {
            String key = entry.getKey();
            int value = Integer.parseInt(entry.getValue());

            for (int i = 0; i < value; i++) {
                String candidate = String.valueOf(key);
                votes.add(new Vote(candidate, election));
            }
        }
   
    
    }
    @Override
    public Map<String,Integer> getVoteResults(){
    	List<Vote> votes = (List<Vote>) voterrepository.findAll();
    	Map<String,Integer> map = new HashMap<String,Integer>();
    	for(Vote voteCount : votes) {
    		if(map.get(voteCount.getCandidate()) == null) {
    			map.put(voteCount.getCandidate(),1);
    		} else {
    			int tmp = map.get(voteCount.getCandidate());
    			tmp ++;
    			map.put(voteCount.getCandidate(), tmp);
    		}
    	}
    	
    	return map;
    }
    
   
    
    @Override
    public Map<String, Integer> getWinner(){
    	List<Vote> votes = (List<Vote>) voterrepository.findAll();
    	TreeMap<String,Integer> map = new TreeMap<String,Integer>(Collections.reverseOrder());
    	for(Vote voteCount : votes) {
    		if(map.get(voteCount.getCandidate()) == null) {
    			map.put(voteCount.getCandidate(),1);
    		} else {
    			int tmp = map.get(voteCount.getCandidate());
    			tmp ++;
    			map.put(voteCount.getCandidate(), tmp);
    		}
    	}
    	
    	 return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
    			 .collect(Collectors.toMap(
    					 Map.Entry::getKey, 
    					 Map.Entry::getValue, 
    					 (e1, e2) -> e1, 
    					 LinkedHashMap::new
    					 ));
    	 
    }
    
   // retourner le resultat de l'election 
    public Entry<String, Integer> result(){  
    	Map<String,Integer> map= getWinner();
        Entry<String, Integer> maxEntry = null;
        Integer max = Collections.max(map.values());

        for(Entry<String, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if(null != value && max == value) {
                maxEntry = entry;
            }
        }
        return maxEntry;
    }
    
 // generates random number of total votes for each candidate using Queue to DB
    public void setRandomVotesDb(String election) {
        Map candidates = new HashMap();
        List<Candidat> list = icandidatservice.getCandidates();
        for (Candidat aList : list) {
            candidates.put(aList.getFirstName(), getRandomIntAsString(3, 25));
        }
        votesFromMap(candidates, election);
    }

    // returns random number as string
    public String getRandomIntAsString(int min, int max) {
        int randomVoteCount = ThreadLocalRandom.current().nextInt(min, max + 1);
        return Integer.toString(randomVoteCount);
    }
    
    public int getNombreVoteJPQL() {
		return voterrepository.countvote();
	}

    
		
	}
    
   


