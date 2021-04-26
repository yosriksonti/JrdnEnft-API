package tn.kindergarten.spring.service;

import java.util.List;

import tn.kindergarten.spring.entities.Daycare;
import tn.kindergarten.spring.entities.Visitor;

public interface IVisitorService {
	public int addVisitorr(Visitor visitor, String idfiledb);
	public void updateVisitor(Visitor visitor,int id);
	public void deleteVisitor(int visitortId);
	public Visitor read (int id);
	public Visitor setVIP(int id);
	public List<Daycare> getClosest(Visitor visitor);
	public List<Daycare> getDaycaresForVisitor(Visitor visitor);
}
