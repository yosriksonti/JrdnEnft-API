package tn.kindergarten.spring.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import tn.kindergarten.spring.entities.Payment;
@Service
public class PaymentService implements IPaymentService
{
	
	
	@Autowired
	VisitorServiceImpl visitorService;
	 private final RestTemplate restTemplate;

	    public PaymentService(RestTemplateBuilder restTemplateBuilder) 
	    {
	        this.restTemplate = restTemplateBuilder.build();
	    }

	    public String getPostsPlainJSON() {
	        String url = "https://api.preprod.konnect.network/api/v1/payments/init-payment";
	        return this.restTemplate.getForObject(url, String.class);
	    }
	    
	    
	    
	    
	    
	@Override
	public String postPayment(Payment payment)
	{
	    String url = "https://api.preprod.konnect.network/api/v1/payments/init-payment";

	    // create headers
	    HttpHeaders headers = new HttpHeaders();
	    // set `content-type` header
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    // set `accept` header
	    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

	    // create a map for post parameters JSON(Key/Value)
	    Map<String, Object> map = new HashMap<>();
	    map.put("receiverWallet", "600216e6fd5f7e2d78da9bf4");
	    map.put("amount",payment.getAmount());
	    map.put("successUrl",payment.getSuccessUrl());
	    map.put("failUrl",payment.getFailUrl());
	    map.put("firstName", payment.getVisitor().getName());
	    map.put("lastName", payment.getVisitor().getLastname());
	    map.put("orderId", payment.getVisitor().getId());
	    map.put("phoneNumber", payment.getVisitor().getPhonenumber());
	    map.put("token", payment.getToken());
	    map.put("selectedPaymentMethod", payment.getSelectedPaymentMethod());



	    

	    map.put("body", "Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications.");
	    

	    // build the request
	    HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

	    // send POST request
	    ResponseEntity<String> response = this.restTemplate.postForEntity(url, entity, String.class);
	    
	    // check response status code
	    if (response.getStatusCode() == HttpStatus.OK) 
	    {
	    	String respString = response.toString();
	    	;
	    	//Json Parser
//	    	try {
//	    	JSONObject obj = new JSONObject(response );
	    	String firstSlice = respString.substring(respString.indexOf("\"payUrl\":\"")+"\"payUrl\":\"".length());
	    	String secondSlice = firstSlice.substring(0,firstSlice.indexOf("\","));
	    	System.out.println(respString);
	    	System.out.println(firstSlice);
	    	System.out.println(secondSlice);
	    	return secondSlice;
//	    	} catch ( JSONException ex) {
//	    		throw new Error(ex);
//	    	}
	    } else {
	    	System.out.println(response.getStatusCode());
	        return null;
	    }
	}


	

	@Override
	public String getPayment(String paymentRef) {
		String url = "https://api.preprod.konnect.network/api/v1/payments/"+paymentRef;
        String resp = this.restTemplate.getForObject(url, String.class);
        String firstSlice = resp.substring(resp.indexOf("\"status\":\"")+"\"status\":\"".length());
    	String secondSlice = firstSlice.substring(0,firstSlice.indexOf("\","));
    	System.out.println(firstSlice);
    	System.out.println(secondSlice);
    	if(secondSlice.equals("completed")) {
    		String url2 = "https://api.preprod.konnect.network/api/v1/payments/"+paymentRef;
            String resp2 = this.restTemplate.getForObject(url2, String.class);
            String firstSlice2 = resp2.substring(resp2.indexOf("\"orderId\":\"")+"\"orderId\":\"".length());
        	String secondSlice2 = firstSlice2.substring(0,firstSlice2.indexOf("\","));
        	System.out.println(firstSlice2);
        	System.out.println(secondSlice2);
    		visitorService.setVIP(Integer.parseInt(secondSlice2));
    	}

		return secondSlice;
	}

}
