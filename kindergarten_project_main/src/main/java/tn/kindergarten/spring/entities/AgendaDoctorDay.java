package tn.kindergarten.spring.entities;

import java.io.Serializable;
import java.util.Date;



public class AgendaDoctorDay implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Doctor doc;
	private Date day;
	private DocAvaibilityDay[] docAvaiblityday;
	public Doctor getDoc() {
		return doc;
	}
	public void setDoc(Doctor doc) {
		this.doc = doc;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public DocAvaibilityDay[] getDocAvaiblityday() {
		return docAvaiblityday;
	}
	public void setDocAvaiblityday(DocAvaibilityDay[] docAvaiblityday) {
		this.docAvaiblityday = docAvaiblityday;
	}
	public AgendaDoctorDay(Doctor doc, Date day, DocAvaibilityDay[] docAvaiblityday) {
		super();
		this.doc = doc;
		this.day = day;
		this.docAvaiblityday = docAvaiblityday;
	}
	
	
	public AgendaDoctorDay()
	{
		
	}
	
	
	
	
	
	
	

}
