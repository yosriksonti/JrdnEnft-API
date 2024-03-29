package tn.kindergarten.spring.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@MappedSuperclass
@Inheritance(strategy=InheritanceType.JOINED)
public class ProfilAdmin {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 




	

	protected String name;
	protected String lastname;
	protected int phonenumber;
	
	//@Column(unique=true)
	protected String email;
	protected String Address;
	protected String Password;
	protected String Image;
	protected String cin;
	protected String login;


	@Temporal(TemporalType.DATE)
	protected Date birthday;
	
	public Date getBirthday() {
		return birthday;
	}

	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Enumerated(EnumType.STRING)
	//@NotNull
	protected RoleAdmin roleA;
	


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

	public RoleAdmin getRoleA() {
		return roleA;
	}

	public void setRoleA(RoleAdmin roleA) {
		this.roleA = roleA;
	}

	public ProfilAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ProfilAdmin(String name, String lastname, int phonenumber, String email, String address, String password,
			String image, String cin, String login, Date birthday, RoleAdmin roleA) {
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
		this.birthday = birthday;
		this.roleA = roleA;
	}
	
	
	
	

}
