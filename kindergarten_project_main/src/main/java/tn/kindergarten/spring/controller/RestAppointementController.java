package tn.kindergarten.spring.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.kindergarten.spring.entities.Appointement;
import tn.kindergarten.spring.entities.Evenement;
import tn.kindergarten.spring.entities.Vote;
import tn.kindergarten.spring.message.ResponseMessage;
import tn.kindergarten.spring.repository.AppointementRepository;
import tn.kindergarten.spring.service.IApointementservice;


@RestController
public class RestAppointementController {
	
@Autowired
IApointementservice iApointementservice ;
@Autowired
AppointementRepository appointementRepository;
@PostMapping("/appointementsadd")
@ResponseBody
public  ResponseEntity<String> appointementsAdd(@RequestBody Appointement appointement) throws Exception 
{
	try {
		iApointementservice.getFirstShift(appointement.getManeger().getId(), appointement.getParent().getId());
		return new ResponseEntity<String>("Réponse du serveur: "+HttpStatus.OK.name(), HttpStatus.OK);
	} catch (Exception ex) {
		throw new Exception (ex);
	}}

}
