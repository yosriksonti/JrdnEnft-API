package tn.kindergarten.spring.entities;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;


@Table(name = "Availability")
@Entity

public class DoctorAvailability implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name="doc_id" , nullable = true)
	private Doctor doc;
	
	@Column (name = "id_doctor")
	private int doctor;
	private int hdebut;
	private int mdebut;
	private int hfin;
	private int mfin;
	
	
	
	@OneToMany(mappedBy = "availability")
	private List<AppoitementDoc> Apps ;


	public int getDoctor() {
		return doctor;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Doctor getDoc() {
		return doc;
	}



	public void setDoc(Doctor doc) {
		this.doc = doc;
	}



	public void setDoctor(int doctor) {
		this.doctor = doctor;
	}



	public void setDoctor(Doctor doc) {
		this.doc = doc;
	}



	public int getHdebut() {
		return hdebut;
	}



	public void setHdebut(int hdebut) {
		this.hdebut = hdebut;
	}



	public int getMdebut() {
		return mdebut;
	}



	public void setMdebut(int mdebut) {
		this.mdebut = mdebut;
	}



	public int getHfin() {
		return hfin;
	}



	public void setHfin(int hfin) {
		this.hfin = hfin;
	}



	public int getMfin() {
		return mfin;
	}



	public void setMfin(int mfin) {
		this.mfin = mfin;
	}



	public List<AppoitementDoc> getApps() {
		return Apps;
	}



	public void setApps(List<AppoitementDoc> apps) {
		Apps = apps;
	}

	
	

	
	public DoctorAvailability()
	{
		
	}



	public DoctorAvailability(Doctor doc, int doctor, int hdebut, int mdebut, int hfin, int mfin,
			List<AppoitementDoc> apps) {
		super();
		this.doc = doc;
		this.doctor = doctor;
		this.hdebut = hdebut;
		this.mdebut = mdebut;
		this.hfin = hfin;
		this.mfin = mfin;
		Apps = apps;
	}









	
	
	

}
