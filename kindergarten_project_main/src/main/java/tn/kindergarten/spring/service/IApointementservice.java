package tn.kindergarten.spring.service;

import java.sql.Date;
import java.util.List;

import tn.kindergarten.spring.entities.Appointement;

public interface IApointementservice {
	public Appointement getFirstShift(int managerid,int parentid) throws Exception;
}
