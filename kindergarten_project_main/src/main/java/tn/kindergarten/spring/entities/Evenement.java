package tn.kindergarten.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Evenement implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
    private String name;
	private String type;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="dd/MM/yy")
	private Date date;
	private String image;
	private int idorganisateur;
    private String nameorganisateur;
	private String nbParticipant;
	private String atelier;
	
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
	
	public int getIdorganisateur() {
		return idorganisateur;
	}
	public void setIdorganisateur(int idorganisateur) {
		this.idorganisateur = idorganisateur;
	}
	public String getNameorganisateur() {
		return nameorganisateur;
	}
	public void setNameorganisateur(String nameorganisateur) {
		this.nameorganisateur = nameorganisateur;
	}
	public Evenement(String name, String type, Date date, String image, String organisateur, String nbParticipant,
			String atelier) {
		super();
		this.name = name;
		this.type = type;
		this.date = date;
		this.image = image;
		
		this.nbParticipant = nbParticipant;
		this.atelier = atelier;
	}
	public Evenement(int id) {
		super();
		this.id = id;
	}
	
	
	
	public Evenement(String name, String type, Date date, String image, int idorganisateur, String nameorganisateur,
			String nbParticipant, String atelier) {
		super();
		this.name = name;
		this.type = type;
		this.date = date;
		this.image = image;
		this.idorganisateur = idorganisateur;
		this.nameorganisateur = nameorganisateur;
		this.nbParticipant = nbParticipant;
		this.atelier = atelier;
	}
	public Evenement() {
		super();
	}
	
	
	
	
	
}
