package tn.kindergarten.spring.service;


import java.sql.Date;
import java.util.List;
import java.util.Map;

import tn.kindergarten.spring.entities.Appointement;

public interface IApointementservice {

	Appointement getFirstShift(int managerid, int parentid) throws Exception;



}
