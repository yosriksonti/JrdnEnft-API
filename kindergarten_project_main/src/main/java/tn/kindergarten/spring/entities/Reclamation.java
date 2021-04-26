package tn.kindergarten.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Reclamation implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String RecName;
	private String descripRec;
	@Enumerated(EnumType.STRING)
	//@NotNull
	protected TypeReclamation typeRec;
	



	@Temporal(TemporalType.DATE)
    private Date dateRec;
    @ManyToOne
    private Parent parent;
    @ManyToOne
    private Daycare daycare;
    
  
	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}
	
	public TypeReclamation getTypeRec() {
		return typeRec;
	}

	public void setTypeRec(TypeReclamation typeRec) {
		this.typeRec = typeRec;
	}

	

	public Daycare getDaycare() {
		return daycare;
	}

	public void setDaycare(Daycare daycare) {
		this.daycare = daycare;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRecName() {
		return RecName;
	}

	public void setRecName(String recName) {
		RecName = recName;
	}

	public String getDescripRec() {
		return descripRec;
	}

	public void setDescripRec(String descripRec) {
		this.descripRec = descripRec;
	}

	public Date getDateRec() {
		return dateRec;
	}

	public void setDateRec(Date dateRec) {
		this.dateRec = dateRec;
	}

	public Reclamation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reclamation(String recName, String descripRec, TypeReclamation typeRec, Date dateRec, Parent parent,
			Daycare daycare) {
		super();
		this.RecName = recName;
		this.descripRec = descripRec;
		this.typeRec = typeRec;
		this.dateRec = dateRec;
		this.parent = parent;
		this.daycare = daycare;
	}



	
	
	
	
	

}
