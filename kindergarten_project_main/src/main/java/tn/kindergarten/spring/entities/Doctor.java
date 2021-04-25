package tn.kindergarten.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="DOCTOR")
public class Doctor extends ProfilAdmin implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	@OneToOne 
	private Daycare daycare;
	
	
	@OneToMany(mappedBy="doc")
	private List<HealthRecord> healthRecords;
	
	@OneToMany(mappedBy="doc")
	private List<DoctorAvailability> avaibility;


	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Doctor(String name, String lastname, int phonenumber, String email, String address, String password,
			String image, String cin, String login, Date birthday, RoleAdmin roleA , List<DoctorAvailability> avaibility) {
		super(name, lastname, phonenumber, email, address, password, image, cin, login, birthday, roleA);
		this.avaibility = avaibility;
		// TODO Auto-generated constructor stub
	}
	
	public List<DoctorAvailability> getAvaibility() {
		return avaibility;
	}

	public void setAvaibility(List<DoctorAvailability> avaibility) {
		this.avaibility = avaibility;
	}







	
	
	


	
	
}
