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
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Parent implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String email;
	private String password;
	
	
	//@JsonBackReference  
	@JsonIgnore
	@OneToMany(mappedBy="parent",fetch=FetchType.EAGER )
	//@NotNull
	
	private List<Child> children;
	
//	@ManyToOne
//	//@NotNull
//	private Daycare daycare;

	@Enumerated(EnumType.STRING)
	//@NotNull
	private Status Status;

	public Parent() {}

	public Parent(int id, String email, String password, List<Child> children, Daycare daycare,
			tn.kindergarten.spring.entities.Status status) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.children = children;
		Status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Child> getChildren() {
		return children;
	}

	public void setChildren(List<Child> children) {
		this.children = children;
	}
//
//	public Daycare getDaycare() {
//		return daycare;
//	}
//
//	public void setDaycare(Daycare daycare) {
//		this.daycare = daycare;
//	}

	public Status getStatus() {
		return Status;
	}

	public void setStatus(Status status) {
		Status = status;
	}
	
	

	
	

}
