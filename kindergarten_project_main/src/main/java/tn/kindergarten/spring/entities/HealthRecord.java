package tn.kindergarten.spring.entities;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class HealthRecord {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date AppointDate;
	private String description;
	private String etat;
	private String images;
	
	
	  //@OneToOne
		 // @JoinColumn(name = "kindergarten_fk")
		//private Daycare idKid;

	
	

}
