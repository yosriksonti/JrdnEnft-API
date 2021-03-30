package tn.kindergarten.spring.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	@Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")

	private Date date;
	@OneToOne
	private Parent Parent;
	@OneToOne
	private Manager maneger;
	@Enumerated(EnumType.STRING)
	private shifts shift;
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
	public Appointement(Date date, tn.kindergarten.spring.entities.Parent parent, Manager maneger,shifts shift) {
		super();
		this.date = date;
		Parent = parent;
		this.maneger = maneger;
		this.shift = shift;
	}
	
	
	
	public Appointement(int id, Date date, shifts shift) {
		super();
		this.id = id;
		this.date = date;
		this.shift = shift;
	}
	public Appointement(Date date2, Manager tmpManager, tn.kindergarten.spring.entities.Parent tmpParent,
			shifts shifts) {
		// TODO Auto-generated constructor stub
	}
	public Appointement(LocalDate plusDays, tn.kindergarten.spring.entities.Parent tmpParent, Manager tmpManager,
			shifts shifts) {
		// TODO Auto-generated constructor stub
	}
	public Parent getParent() {
		return Parent;
	}
	public void setParent(Parent parent) {
		Parent = parent;
	}
	public Manager getManeger() {
		return maneger;
	}
	public void setManeger(Manager maneger) {
		this.maneger = maneger;
	}
	public shifts getShift() {
		return shift;
	}
	public void setShift(shifts shift) {
		this.shift = shift;
	}
	
	
	
	
	
	
	

	
	
	
}
