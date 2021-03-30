package tn.kindergarten.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)

public class Evenement implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
    private String name;
	private String type;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="dd/MM/yy")
	private Date date;
	private String image;
	private String nbParticipant;
	private String atelier;
	@ManyToOne
	private Manager manager;
	@ManyToMany
	private List<Parent> parents;
	@OneToOne()
	@JoinColumn(name="FK_TPA_ID")
    private FileDB filedb;
	
	
	public FileDB getFiledb() {
		return filedb;
	}
	public void setFiledb(FileDB filedb) {
		this.filedb = filedb;
	}
	public List<Parent> getParents() {
		return parents;
	}
	public void setParents(List<Parent> parents) {
		this.parents = parents;
	}
	public  int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getNbParticipant() {
		return nbParticipant;
	}
	public void setNbParticipant(String nbParticipant) {
		this.nbParticipant = nbParticipant;
	}
	public String getAtelier() {
		return atelier;
	}
	public void setAtelier(String atelier) {
		this.atelier = atelier;
	}
	
	
	
	public Evenement(int id) {
		super();
		this.id = id;
	}
	
	
	
	
	public Evenement(String name, String type, Date date, String image, String nbParticipant, String atelier,
			Manager manager, List<Parent> parents) {
		super();
		this.name = name;
		this.type = type;
		this.date = date;
		this.image = image;
		this.nbParticipant = nbParticipant;
		this.atelier = atelier;
		this.manager = manager;
		this.parents = parents;
	}
	public Evenement(int id, String name, String type, Date date, String image, String nbParticipant, String atelier,
			Manager manager, List<Parent> parents) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.date = date;
		this.image = image;
		this.nbParticipant = nbParticipant;
		this.atelier = atelier;
		this.manager = manager;
		this.parents = parents;
	}
	public Evenement() {
		super();
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	
	
	
	
	
	
}
