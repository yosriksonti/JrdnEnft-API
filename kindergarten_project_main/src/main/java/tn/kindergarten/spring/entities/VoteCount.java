package tn.kindergarten.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class VoteCount implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String candidate;
	@Column(name="vote")
    private String election;


	

	

	public VoteCount(int id, String candidate, String election) {
		super();
		this.id = id;
		this.candidate = candidate;
		this.election = election;
	}

	public VoteCount(String candidate, String election) {
		super();
		this.candidate = candidate;
		this.election = election;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCandidate() {
		return candidate;
	}

	public void setCandidate(String candidate) {
		this.candidate = candidate;
	}

	public String getElection() {
		return election;
	}

	public void setElection(String election) {
		this.election = election;
	}


    
}
