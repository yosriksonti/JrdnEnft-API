package tn.kindergarten.spring.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Daycare implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String region;
	
	private String logo;
	
	private String reputation;
	
	private int nbReclamations ;
	
	//@JsonBackReference  
	@JsonIgnore
	@OneToOne(mappedBy="daycare",fetch=FetchType.EAGER )
	//@NotNull
	private Doctor doctor;
	
	//@JsonBackReference  
		@JsonIgnore
		@ManyToOne
		@JoinColumn(name="manager_id", nullable=false)
		private ProfilAdmin manager;
		
		@JsonIgnore
		@OneToMany(mappedBy="daycare",fetch=FetchType.EAGER )
		private List<Parent> parents = new ArrayList<Parent>();
		
		@OneToMany(mappedBy="daycare")
		private List<HealthRecord> healthRecords;
		
		
		//@JsonBackReference  
		@JsonIgnore
		@OneToOne(mappedBy="daycare",fetch=FetchType.EAGER )
		//@NotNull
		private Director director;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getRegion() {
			return region;
		}

		public void setRegion(String region) {
			this.region = region;
		}

		public String getLogo() {
			return logo;
		}

		public void setLogo(String logo) {
			this.logo = logo;
		}

		public String getReputation() {
			return reputation;
		}

		public void setReputation(String reputation) {
			this.reputation = reputation;
		}

		public int getNbReclamations() {
			return nbReclamations;
		}

		public void setNbReclamations(int nbReclamations) {
			this.nbReclamations = nbReclamations;
		}

		public Doctor getDoctor() {
			return doctor;
		}

		public void setDoctor(Doctor doctor) {
			this.doctor = doctor;
		}

		public ProfilAdmin getManagers() {
			return manager;
		}

		public void setManagers(ProfilAdmin manager) {
			this.manager = manager;
		}

		public List<Parent> getParents() {
			return parents;
		}

		public void setParents(List<Parent> parents) {
			this.parents = parents;
		}

		public Director getDirector() {
			return director;
		}

		public void setDirector(Director director) {
			this.director = director;
		}
	
}
