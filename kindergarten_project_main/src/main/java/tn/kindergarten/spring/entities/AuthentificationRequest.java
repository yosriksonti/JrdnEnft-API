package tn.kindergarten.spring.entities;

public class AuthentificationRequest {

	private String username;
	private String password;
	
	public AuthentificationRequest() {
	}

	public AuthentificationRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
