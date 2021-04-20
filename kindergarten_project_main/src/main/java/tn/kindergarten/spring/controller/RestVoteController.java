package tn.kindergarten.spring.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import tn.kindergarten.spring.entities.Appointement;
import tn.kindergarten.spring.entities.Candidat;
import tn.kindergarten.spring.entities.Vote;
import tn.kindergarten.spring.entities.VoteCount;
import tn.kindergarten.spring.repository.VoterRepository;
import tn.kindergarten.spring.service.IVoterService;
import tn.kindergarten.spring.service.Icandidatservice;

import java.util.List;

@RestController
public class RestVoteController {
@Autowired
IVoterService ivoterservice;
@Autowired
VoterRepository voterrepository;
@Autowired
Icandidatservice icandidatservice;


///////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////simuler vote /////////////////////////////////////////////
	@RequestMapping(value = "/simulation/{election}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, String>> getSimulationDb(@PathVariable("election") String election) {

        // voterRepository.deleteAll();
		ivoterservice.setRandomVotesDb(election);
		List<Vote> votes=ivoterservice.getVotes();
		voterrepository.saveAll(votes);
        Map<String, String> result = new HashMap<>();
        result.put("message", "Simulation data created using eventual consistency!");
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

	
    // used by unit tests to create a known data set
    public void getSimulation(Map candidates, String election) {

    	voterrepository.deleteAll();
    	ivoterservice.votesFromMap(candidates, election);
    	voterrepository.saveAll(ivoterservice.getVotes());
    }
    
  /////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////
    //////////////////retourner Liste candidat avec leur vote////////////////////
    @RequestMapping(value = "/results/{election}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Integer>> getResults(@PathVariable("election") String election) throws Exception 
    {

    Map<String,Integer> votes=  ivoterservice.getVoteResults();
		
    	  return new ResponseEntity<>(votes, HttpStatus.OK);
    	
    }
    ////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////
    
    
    
    ////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////
    //retourner les resultat trier de l'election 

    @RequestMapping(value = "/winners/{election}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Integer>> getwinners(@PathVariable("election") String election) throws Exception 
    {

    	Map<String,Integer> winner=   ivoterservice.getWinner();
		
    	  return new ResponseEntity<>(winner, HttpStatus.OK);
    	
    }
    
    ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
    ////////////////////////afficher winner///////////////////////////////
    @RequestMapping(value = "/result/{election}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Entry<String, Integer>> getresult(@PathVariable("election") String election) throws Exception 
    {

    	Entry<String,Integer> winner=   ivoterservice.result();
		
    	  return new ResponseEntity<>(winner, HttpStatus.OK);
    	
    }
    
  //////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////
    
    @GetMapping("/users/export")
    public void exportToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date(0));
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);
         
        List<Candidat> listUsers = icandidatservice.getCandidates();
 
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"User ID", "firstName", "lastName", "election"};
        String[] nameMapping = {"id", "firstName", "lastName", "election"};
         
        csvWriter.writeHeader(csvHeader);
         
        for (Candidat user : listUsers) {
            csvWriter.write(user, nameMapping);
        }
         
        csvWriter.close();
         
    }
    
    
    
}
