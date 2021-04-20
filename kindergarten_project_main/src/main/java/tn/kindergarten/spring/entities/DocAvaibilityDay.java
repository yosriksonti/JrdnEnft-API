package tn.kindergarten.spring.entities;

import java.io.Serializable;

public class DocAvaibilityDay  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private DoctorAvailability availabiltiy;
	private AppoitementDoc app;
	
	
	
	public DoctorAvailability getAvailabiltiy() {
		return availabiltiy;
	}
	
	
	public void setAvailabiltiy(DoctorAvailability availabiltiy) {
		this.availabiltiy = availabiltiy;
	}
	public AppoitementDoc getApp() {
		return app;
	}
	public void setApp(AppoitementDoc app) {
		this.app = app;
	}
	public DocAvaibilityDay(DoctorAvailability availabiltiy, AppoitementDoc app) {
		super();
		this.availabiltiy = availabiltiy;
		this.app = app;
	}
	
	public DocAvaibilityDay()
	{
		
	}
	
	
	
	
	
	

}
