package tn.kindergarten.spring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Manager extends ProfilAdmin implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private boolean isActive;
	
	@OneToMany(mappedBy="manager" )
	private List<Daycare> daycares = new ArrayList<Daycare>();

	public List<Daycare> getDaycares() {
		return daycares;
	}
	public void setDaycares(List<Daycare> daycares) {
			this.daycares = daycares;
		}

	public Manager(boolean isActive) {
		super();
		this.isActive= isActive;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	

}
