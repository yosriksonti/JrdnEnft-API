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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class HealthRecord implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="dd/MM/yy")
	private Date AppointDate;
	private String description;
	private String etat;
	private String images;

	
	
	@ManyToOne
    @JoinColumn(name="daycare_id", nullable=false)
	private Daycare daycare;
	
	
	
	@ManyToOne
    @JoinColumn(name="doc_id", nullable=false)
	private Doctor doc;
	
	@ManyToOne
	@JoinColumn(name="parent_id", nullable=false)
	private Parent healthrecordsParent;
	
	
	
	
	public HealthRecord(int id, Date appointDate, String description, String etat, String images) {
		super();
		this.id = id;
		AppointDate = appointDate;
		this.description = description;
		this.etat = etat;
		this.images = images;
	
	}

	

	public HealthRecord()
	{
		
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getAppointDate() {
		return AppointDate;
	}


	public void setAppointDate(Date appointDate) {
		AppointDate = appointDate;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
	}


	public String getImages() {
		return images;
	}


	public void setImages(String images) {
		this.images = images;
	}





	
	

}
