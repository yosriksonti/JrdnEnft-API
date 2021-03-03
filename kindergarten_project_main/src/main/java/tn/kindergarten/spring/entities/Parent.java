package tn.kindergarten.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Parent implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	//@JsonBackReference  
	@JsonIgnore
	@OneToMany(mappedBy="parent",fetch=FetchType.EAGER )
	//@NotNull
	private List<Child> children;
	
	@Enumerated(EnumType.STRING)
	//@NotNull
	private Status Status;


}
