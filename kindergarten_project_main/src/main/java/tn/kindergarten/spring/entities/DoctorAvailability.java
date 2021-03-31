package tn.kindergarten.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class DoctorAvailability implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@ManyToOne
    @JoinColumn(name="doc_id", nullable=false)
	private Doctor doc;
	
	private  boolean Availability ;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date beginwork;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date endwork;

	public boolean isAvailability() {
		return Availability;
	}
	
	public DoctorAvailability()
	{
		
	}
	
	

	public DoctorAvailability(boolean availability, Date beginwork, Date endwork) {
		super();
		Availability = availability;
		this.beginwork = beginwork;
		this.endwork = endwork;
	}




	public void setAvailability(boolean availability) {
		Availability = availability;
	}

	public Date getBeginwork() {
		return beginwork;
	}

	public void setBeginwork(Date beginwork) {
		this.beginwork = beginwork;
	}

	public Date getEndwork() {
		return endwork;
	}

	public void setEndwork(Date endwork) {
		this.endwork = endwork;
	}
	
	
	
	

}
