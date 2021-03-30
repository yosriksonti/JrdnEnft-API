package tn.kindergarten.spring.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.sun.istack.NotNull;



import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;


@Entity
@Table(name = "Doc appoitement")

public class AppoitementDoc implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "jour", nullable = false)
	@Temporal(TemporalType.DATE)
	@NotNull
	
	private Date day;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_parent")
	private Parent parent;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_availability")
	private DoctorAvailability availability;
	
	
	
	@Column(name = "id_parent", nullable = false, insertable = false, updatable = false)
	private long idParent;
	
	@Column(name = "id_availability", nullable = false, insertable = false, updatable = false)
	private long idAvailability;
	
	
	public long getIdAvailability() {
		return idAvailability;
	}

	public long getParent() {
		return idParent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
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

	
	
	
}
