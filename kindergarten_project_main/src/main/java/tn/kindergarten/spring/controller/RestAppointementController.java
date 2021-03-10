package tn.kindergarten.spring.controller;

import org.hibernate.query.criteria.internal.CriteriaUpdateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.kindergarten.spring.entities.Appointement;
import tn.kindergarten.spring.entities.Evenement;
import tn.kindergarten.spring.service.AppointementImpl;
import tn.kindergarten.spring.service.IApointementservice;
@RestController
public class RestAppointementController {
@Autowired
IApointementservice iApointementservice ;

@PostMapping("/appointementsadd")
@ResponseBody
public  ResponseEntity<String> appointementsAdd(@RequestBody Appointement appointement) throws Exception 
{
	try {
		iApointementservice.getFirstShift(appointement.getManeger().getId(), appointement.getParent().getId());
		return new ResponseEntity<String>("Réponse du serveur: "+HttpStatus.OK.name(), HttpStatus.OK);
	} catch (Exception ex) {
		throw new Exception (ex);
	}
	


}
}
