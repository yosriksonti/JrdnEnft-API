package tn.kindergarten.spring.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Doctor extends ProfilAdmin {
	
	private  boolean Availability ;
	
	
	@OneToOne 
	// @JoinColumn(name=Kindergarten)
	private Daycare daycare;

	public boolean isAvailability() {
		return Availability;
	}







	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}







	public Doctor(String name, String lastname, int phonenumber, String email, String address, String password,
			String image, String cin, String login, Date birthday, RoleAdmin roleA) {
		super(name, lastname, phonenumber, email, address, password, image, cin, login, birthday, roleA);
		// TODO Auto-generated constructor stub
	}






	
	
	


	
	
}
