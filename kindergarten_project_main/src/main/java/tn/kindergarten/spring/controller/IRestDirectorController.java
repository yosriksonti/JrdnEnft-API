package tn.kindergarten.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.kindergarten.spring.service.IDirectorService;

@Controller
public class IRestDirectorController {
	@Autowired
	IDirectorService idirectorservice;
	
}
