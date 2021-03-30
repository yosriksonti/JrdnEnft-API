package tn.kindergarten.spring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Manager extends ProfilAdmin implements Serializable {
	
	
	


	private boolean isActive;
	
	@OneToMany(mappedBy="manager" )
	private List<Daycare> daycares;

	public Manager() {
		super();
	}
	public Manager(boolean isActive, List<Daycare> daycares) {
		super();
		this.isActive = isActive;
		this.daycares = daycares;
	}
	public List<Daycare> getDaycares() {
		return daycares;
	}
	public void setDaycares(List<Daycare> daycares) {
			this.daycares = daycares;
		}

	public Manager(boolean isActive) {
		super();
		this.isActive= isActive;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public Date getBirthday() {
		// TODO Auto-generated method stub
		return super.getBirthday();
	}
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}
	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}
	@Override
	public void setBirthday(Date birthday) {
		// TODO Auto-generated method stub
		super.setBirthday(birthday);
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}
	@Override
	public String getLastname() {
		// TODO Auto-generated method stub
		return super.getLastname();
	}
	@Override
	public void setLastname(String lastname) {
		// TODO Auto-generated method stub
		super.setLastname(lastname);
	}
	@Override
	public int getPhonenumber() {
		// TODO Auto-generated method stub
		return super.getPhonenumber();
	}
	@Override
	public void setPhonenumber(int phonenumber) {
		// TODO Auto-generated method stub
		super.setPhonenumber(phonenumber);
	}
	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}
	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		super.setEmail(email);
	}
	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return super.getAddress();
	}
	@Override
	public void setAddress(String address) {
		// TODO Auto-generated method stub
		super.setAddress(address);
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}
	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		super.setPassword(password);
	}
	@Override
	public String getImage() {
		// TODO Auto-generated method stub
		return super.getImage();
	}
	@Override
	public void setImage(String image) {
		// TODO Auto-generated method stub
		super.setImage(image);
	}
	@Override
	public String getCin() {
		// TODO Auto-generated method stub
		return super.getCin();
	}
	@Override
	public void setCin(String cin) {
		// TODO Auto-generated method stub
		super.setCin(cin);
	}
	@Override
	public String getLogin() {
		// TODO Auto-generated method stub
		return super.getLogin();
	}
	@Override
	public void setLogin(String login) {
		// TODO Auto-generated method stub
		super.setLogin(login);
	}
	@Override
	public RoleAdmin getRoleA() {
		// TODO Auto-generated method stub
		return super.getRoleA();
	}
	@Override
	public void setRoleA(RoleAdmin roleA) {
		// TODO Auto-generated method stub
		super.setRoleA(roleA);
	}
	
	

}
