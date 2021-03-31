package tn.kindergarten.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.kindergarten.spring.entities.Payment;
import tn.kindergarten.spring.entities.Visitor;
import tn.kindergarten.spring.service.IPaymentService;
import tn.kindergarten.spring.service.IVisitorService;
@RestController

public class RestPaymentController 
{

	@Autowired
	IPaymentService iPaymentService ;
	
	@PostMapping("/addPayment")
	@ResponseBody
	public String addPayment(@RequestBody Payment payment)
	{
		return  iPaymentService.postPayment(payment);
	}
	
	@GetMapping("/payment/{paymentRef}")
	@ResponseBody
	public String getPayment(@PathVariable("paymentRef") String paymentRef )
	{
		return iPaymentService.getPayment(paymentRef);
	}
	

}
