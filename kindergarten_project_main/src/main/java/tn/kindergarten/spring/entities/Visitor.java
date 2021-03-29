package tn.kindergarten.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import tn.kindergarten.spring.entities.Favorite;
import tn.kindergarten.spring.entities.Status;


@Entity
public class Visitor implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String lastname;
	
	private int phonenumber;
	
	//@Column(unique=true)
	private String email;
	
    private String Address;
    
    private String Password;
    
    private String Image;
    
    private String cin;
    
    private String login;
    
    @Temporal(TemporalType.DATE)
    private Date birthday;
	
	
	

	
	public Visitor(String name, String lastname, int phonenumber, String email, String address, String password,
			String image, String cin, String login, int id, Date birthday,
			tn.kindergarten.spring.entities.Status status, List<Favorite> favorites) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.phonenumber = phonenumber;
		this.email = email;
		Address = address;
		Password = password;
		Image = image;
		this.cin = cin;
		this.login = login;
		this.id = id;
		this.birthday = birthday;
		Status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	
	
	
	public Status getStatus() {
		return Status;
	}

	public void setStatus(Status status) {
		Status = status;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Visitor() {
		super();
	}

	

	@Enumerated(EnumType.STRING)
	//@NotNull
	private Status Status;
}
