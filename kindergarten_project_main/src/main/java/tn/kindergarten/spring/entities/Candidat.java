package tn.kindergarten.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Candidat implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String firstName;
    private String lastName;
    private String election;
    
	@ManyToMany
	private List<Parent> parents;
	
    
    
    

	public List<Parent> getParents() {
		return parents;
	}
	public void setParents(List<Parent> parents) {
		this.parents = parents;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getElection() {
		return election;
	}
	public void setElection(String election) {
		this.election = election;
	}
	public Candidat(int id, String firstName, String lastName, String election) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.election = election;
	}
	public Candidat(String firstName, String lastName, String election) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.election = election;
	}
	public Candidat() {
		super();
	}
    
    
    
}
