package tn.kindergarten.spring.entities;

import java.util.Date;

public class director extends ProfilAdmin {
   //@OneToOne 
	//@JoinColumn(name=Kindergarten)
	//private Daycare kindergaten;
	public director() {
		super();
		// TODO Auto-generated constructor stub
	}

	public director(String name, String lastname, int phonenumber, String email, String address, String password,
			String image, String cin, String login, Date birthday, RoleAdmin roleA) {
		super(name, lastname, phonenumber, email, address, password, image, cin, login, birthday, roleA);
		// TODO Auto-generated constructor stub
	}

	
	

}
