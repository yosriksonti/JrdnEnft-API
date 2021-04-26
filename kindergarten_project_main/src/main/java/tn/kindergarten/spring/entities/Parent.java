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
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Parent implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private boolean isActive = true;
	private String phoneNumber;
	public Parent(int id, boolean isActive, String phoneNumber, String email, String password, List<Child> children,
			Daycare daycare, tn.kindergarten.spring.entities.Status status) {
		super();
		this.id = id;
		this.isActive = isActive;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.children = children;
		this.daycare = daycare;
		Status = status;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Parent(int id, boolean isActive, String email, String password, List<Child> children, Daycare daycare,
			tn.kindergarten.spring.entities.Status status) {
		super();
		this.id = id;
		this.isActive = isActive;
		this.email = email;
		this.password = password;
		this.children = children;
		this.daycare = daycare;
		Status = status;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	private String email;
	private String password;
	
	
	public Parent(int id, String email, String password, List<Child> children, Daycare daycare,
			tn.kindergarten.spring.entities.Status status) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.children = children;
		this.daycare = daycare;
		Status = status;
	}

	public Parent() {
		super();
		// TODO Auto-generated constructor stub
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

	//@JsonBackReference  
	@JsonIgnore
	@OneToMany(mappedBy="parent",fetch=FetchType.LAZY )
	//@NotNull
	
	private List<Child> children;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Daycare daycare;
	
	public Daycare getDaycare() {
		return daycare;
	}

	public void setDaycare(Daycare daycare) {
		this.daycare = daycare;
	}

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



	public Status getStatus() {
		return Status;
	}

	public void setStatus(Status status) {
		Status = status;
	}


}