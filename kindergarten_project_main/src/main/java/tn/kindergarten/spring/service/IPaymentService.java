package tn.kindergarten.spring.service;

import java.util.Map;

import tn.kindergarten.spring.entities.Payment;

public interface IPaymentService 
{
	
	public String postPayment(Payment payment);
	
	public String getPayment(String Id);

}
