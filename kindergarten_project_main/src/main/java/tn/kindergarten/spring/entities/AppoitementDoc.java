package tn.kindergarten.spring.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;



import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;


@Entity
//@Table(name = "Doc appoitement")

public class AppoitementDoc implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "jour", nullable = false)

	@NotNull
	//@Future(message="appoitement must be in the future")
	private LocalDate day;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_parent")
	private Parent parent;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_availability")
	@JsonIgnore
	private DoctorAvailability availability;
	
	@Column(name = "id_parent", nullable = false, insertable = false, updatable = false)
	private int idParent;
	
	@Column(name = "id_availability", nullable = false, insertable = false, updatable = false)
	private int idAvailability;
	
	@Column(name = "is_Confirmed", nullable = false)
	private boolean isConfirmed;
	
	
	
	
	
	public boolean isConfirmed() {
		return isConfirmed;
	}

	public void setConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

	public int getIdAvailability() {
		return idAvailability;
	}


	public Parent getParent() {
		return parent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDay() {
		return day;
	}

	public void setDay(LocalDate day) {
		this.day = day;
	}

	public DoctorAvailability getAvailability() {
		return availability;
	}

	public void setAvailability(DoctorAvailability availability) {
		this.availability = availability;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public AppoitementDoc() {
		super();
	}

	public AppoitementDoc(LocalDate day, Parent parent, DoctorAvailability availability, int idParent,
			int idAvailability) {
		super();
		this.day = day;
		this.parent = parent;
		this.availability = availability;
		this.idParent = idParent;
		this.idAvailability = idAvailability;
	}

	public int getIdParent() {
		return idParent;
	}

	public void setIdParent(int idParent) {
		this.idParent = idParent;
	}

	public void setIdAvailability(int idAvailability) {
		this.idAvailability = idAvailability;
	}

		
	
	
	
}
