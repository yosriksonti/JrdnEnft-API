package tn.kindergarten.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.kindergarten.spring.entities.AuthentificationRequest;
import tn.kindergarten.spring.entities.AuthentificationResponse;
import tn.kindergarten.spring.entities.Parent;
import tn.kindergarten.spring.service.ParentServiceImpl;
import tn.kindergarten.spring.util.JwtUtil;

@RestController
@RequestMapping("/api")
public class AuthentificationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private ParentServiceImpl parentServiceImp;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody Parent parent)
			throws Exception {

		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(parent.getEmail(), parent.getPassword()));
			

		} catch (Exception ex) {

			return new ResponseEntity<>("Invalid email or password", HttpStatus.CONFLICT);
		}

		final UserDetails userDetails = parentServiceImp.loadUserByUsername(parent.getEmail());
		
		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthentificationResponse(jwt));
	}

}