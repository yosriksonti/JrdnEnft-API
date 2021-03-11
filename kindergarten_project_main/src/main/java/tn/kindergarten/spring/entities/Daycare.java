package tn.kindergarten.spring.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


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
		@ManyToOne
		private Manager manager;

		@JsonIgnore
		@ManyToMany
		@JoinColumn(name="favorite_id", nullable=true)

		private List <Favorite> favorites;
		public Daycare
		(int id, String region, String logo, String reputation, int nbReclamations, Doctor doctor,
				Manager manager, List<Favorite> favorites, List<Parent> parents, List<HealthRecord> healthRecords,
				Director director) {
			super();
			this.id = id;
			this.region = region;
			this.logo = logo;
			this.reputation = reputation;
			this.nbReclamations = nbReclamations;
			this.doctor = doctor;
			this.manager = manager;
			this.favorites = favorites;
			this.parents = parents;
			this.healthRecords = healthRecords;
			this.director = director;
		}
		public List<Favorite> getFavorites() {
			return favorites;
		}
		public void setFavorites(List<Favorite> favorites) {
			this.favorites = favorites;
		}
		public List<HealthRecord> getHealthRecords() {
			return healthRecords;
		}
		public void setHealthRecords(List<HealthRecord> healthRecords) {
			this.healthRecords = healthRecords;
		}

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
		public Daycare() {
			super();
			
		}
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

		public Manager getManager() {
			return manager;
		}

		public void setManager(Manager manager) {
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
