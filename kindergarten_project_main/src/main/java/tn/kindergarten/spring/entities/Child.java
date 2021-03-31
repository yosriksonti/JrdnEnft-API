package tn.kindergarten.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Child implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="parent_id", nullable=false)
	private Parent parent;
	
	public Parent getParent() {
		return parent;
	}

	public Child(int id, Parent parent, String name, String passion, Position position) {
		super();
		this.id = id;
		this.parent = parent;
		this.name = name;
		this.passion = passion;
		this.position = position;
	}
	
	public Child() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	private String name;
	
	private String passion;
	
	@OneToOne
	private Position position;

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassion() {
		return passion;
	}

	public void setPassion(String passion) {
		this.passion = passion;
	}
}