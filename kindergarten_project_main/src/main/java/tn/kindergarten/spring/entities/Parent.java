package tn.kindergarten.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Parent implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	//@JsonBackReference  
	@JsonIgnore
	@OneToMany(mappedBy="parent",fetch=FetchType.EAGER )
	//@NotNull
	private List<Child> children;
	
	@ManyToMany(mappedBy="parents",fetch=FetchType.EAGER )
	//@NotNull
	private List<Daycare> daycares;
	
	@Enumerated(EnumType.STRING)
	//@NotNull
	private Status Status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Child> getChildren() {
		return children;
	}

	public void setChildren(List<Child> children) {
		this.children = children;
	}

	public List<Daycare> getDaycares() {
		return daycares;
	}

	public void setDaycares(List<Daycare> daycares) {
		this.daycares = daycares;
	}

	public Status getStatus() {
		return Status;
	}

	public void setStatus(Status status) {
		Status = status;
	}


}
