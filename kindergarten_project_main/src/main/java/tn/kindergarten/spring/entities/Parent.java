package tn.kindergarten.spring.entities;

import java.io.Serializable;
import java.util.ArrayList;
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
	

	private String email;
	private String password;
	
	private String phonenumber;
	
	
	@OneToMany(mappedBy="healthrecordsParent")
	private List<HealthRecord> healthrecords;
	
	@OneToMany(mappedBy = "parent" , fetch=FetchType.LAZY)   
    private List<AppoitementDoc> Apps = new ArrayList<>();

	//@JsonBackReference  
	@JsonIgnore
	@OneToMany(mappedBy="parent" )
	//@NotNull
	
	private List<Child> children= new ArrayList<Child>();
	
	@ManyToOne
	//@NotNull
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

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}


}
