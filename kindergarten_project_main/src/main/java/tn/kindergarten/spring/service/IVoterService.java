package tn.kindergarten.spring.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import tn.kindergarten.spring.entities.Vote;
import tn.kindergarten.spring.entities.VoteCount;

public interface IVoterService {
    public List<Vote> getVotes() ;
    public void setRandomVotesDb(String election) ;
    public void votesFromMap(Map<String, String> candidates, String election) ;
    public String getRandomIntAsString(int min, int max);
    public int getNombreVoteJPQL() ;
    public Map<String,Integer> getVoteResults();
    public Map<String, Integer> getWinner();
    public Entry<String, Integer> result(); 

}
