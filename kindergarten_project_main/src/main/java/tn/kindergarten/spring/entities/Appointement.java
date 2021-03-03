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
public class Appointement implements Serializable {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="dd/MM/yy")
	private Date date;
	private int idParent;
	private int idmaneger;
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
	public int getIdParent() {
		return idParent;
	}
	public void setIdParent(int idParent) {
		this.idParent = idParent;
	}
	public int getIdmaneger() {
		return idmaneger;
	}
	public void setIdmaneger(int idmaneger) {
		this.idmaneger = idmaneger;
	}
	public Appointement() {
		super();
	}
	public Appointement(Date date, int idParent, int idmaneger) {
		super();
		this.date = date;
		this.idParent = idParent;
		this.idmaneger = idmaneger;
	}
	
	
}
