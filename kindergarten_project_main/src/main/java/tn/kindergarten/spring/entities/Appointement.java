package tn.kindergarten.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class Appointement implements Serializable {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="dd/MM/yy")
	private Date date;
	@OneToOne
	private Parent Parent;
	@OneToOne
	private Manager maneger;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public Appointement() {
		super();
	}
	
	
	
	
	
	public Appointement(Date date, Parent idParent, ProfilAdmin idmaneger) {
		super();
		this.date = date;
		this.Parent = idParent;
		this.maneger = (Manager) idmaneger;
	}
	
	
	
}
