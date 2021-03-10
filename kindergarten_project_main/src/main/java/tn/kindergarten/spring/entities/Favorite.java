package tn.kindergarten.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Favorite implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@JsonIgnore
	//@JsonBackReference
	
	@ManyToMany
	@JoinColumn(name="daycare_id", nullable = true)

	private List <Daycare> daycares;
	
	@ManyToOne
	private Visitor visitor ;
	public Favorite() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Visitor getVisitor() {
		return visitor;
	}
	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}
	public List<Daycare> getDaycares() {
		return daycares;
	}
	public void setDaycares(List<Daycare> daycares) {
		this.daycares = daycares;
	}
	public Favorite(int id, List<Daycare> daycares, Visitor visitor) {
		super();
		this.id = id;
		this.daycares = daycares;
		this.visitor = visitor;
	} 
	
}
