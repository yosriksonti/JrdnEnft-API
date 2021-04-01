package tn.kindergarten.spring.service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmsRequest {

    
    private  String phoneNumber; // destination

   
    private  String message;

    public SmsRequest(@JsonProperty("phoneNumber") String phoneNumber,
                      @JsonProperty("message") String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "SmsRequest{" +
                "phoneNumber= ..." + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

	public void setPhoneNumber(String phone) {
		// TODO Auto-generated method stub
		
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
