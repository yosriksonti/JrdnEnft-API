package tn.kindergarten.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	Visitor visitor; 
	final String receiverWallet = "" ;
	Float  amount ; 
	final String selectedPaymentMethod="gateway" ;
	final String token="TND";
	final String successUrl="https//localhost:8082/paymentsuccess/" ;
	final String failUrl="https//localhost:8082/paymentfailure/";
    String status ="Pending";
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Visitor getVisitor() {
		return visitor;
	}
	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReceiverWallet() {
		return receiverWallet;
	}
	public String getSelectedPaymentMethod() {
		return selectedPaymentMethod;
	}
	public String getToken() {
		return token;
	}
	public String getSuccessUrl() {
		return successUrl;
	}
	public String getFailUrl() {
		return failUrl;
	}
	public Payment(int id, Visitor visitor, Float amount, String status) {
		super();
		this.id = id;
		this.visitor = visitor;
		this.amount = amount;
		this.status = status;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
