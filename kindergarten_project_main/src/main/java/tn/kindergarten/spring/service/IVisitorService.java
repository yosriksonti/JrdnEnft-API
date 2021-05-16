package tn.kindergarten.spring.service;

import tn.kindergarten.spring.entities.Visitor;

public interface IVisitorService {
	public int  addVisitorr(Visitor visitor) ;
	public void updateVisitor(Visitor visitor,int id);
	public void deleteVisitor(int visitortId);
	public Visitor read (int id);
<<<<<<< Updated upstream
=======
	public Visitor setVIP(int id);
	public List<Daycare> getClosest(Visitor visitor);
	public List<Daycare> getDaycaresForVisitor(Visitor visitor);
	public List<Visitor> readAll();
>>>>>>> Stashed changes
}
