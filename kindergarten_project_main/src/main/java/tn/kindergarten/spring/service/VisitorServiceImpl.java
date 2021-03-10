package tn.kindergarten.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.spring.entities.Visitor;
import tn.kindergarten.spring.repository.VisitorRepository;

@Service
public class VisitorServiceImpl implements IVisitorService

{ 
	@Autowired 
	VisitorRepository visitorRepository ;
	@Override
	public int addVisitorr(Visitor visitor) {
		visitorRepository.save(visitor);
		return visitor.getId();
	}
	
	@Override
	public void updateVisitor(Visitor visitor,int visitortId)
	{
		Visitor visitor1 = visitorRepository.findById(visitortId).get();
		visitor1.setName(visitor.getName());
		visitorRepository.save(visitor1);
	}
	@Override
	public void deleteVisitor(int visitortId)
	{
		Visitor visitor = visitorRepository.findById(visitortId).get();
	
		visitorRepository.delete(visitor);
	}
	
	@Override
	public Visitor read (int id) {
		Visitor visitor = visitorRepository.findById(id).get();
		return visitor;
	}
	
}