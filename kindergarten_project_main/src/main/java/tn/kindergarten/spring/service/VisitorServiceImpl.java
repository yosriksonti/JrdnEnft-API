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
<<<<<<< Updated upstream
=======
	@Autowired
	FileDBRepository filedbrepository;
	@Autowired
	DaycareServiceImpl daycareService;
	@Autowired
	DaycareRepository daycareRepository;
	
>>>>>>> Stashed changes
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
		visitor1.setLastname(visitor.getLastname());
		visitor1.setAddress(visitor.getAddress());
		visitor1.setBirthday(visitor.getBirthday());
		visitor1.setImage(visitor.getImage());
		visitor1.setPassword(visitor.getPassword());
		visitor1.setStatus(visitor.getStatus());
		visitor1.setCin(visitor.getCin());
		visitor1.setEmail(visitor.getEmail());
		visitor1.setLogin(visitor.getLogin());
		visitor1.setPhonenumber(visitor.getPhonenumber());
		System.out.println(visitor1.getId());
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
		System.out.println(id);
		Visitor visitor = visitorRepository.findById(id).get();
		return visitor;
	}
	
	public Visitor setVIP(int id) {
		Visitor visitor = visitorRepository.findById(id).get();
		visitor.setVIP(true);
		visitorRepository.save(visitor);
		return visitor;
	}
<<<<<<< Updated upstream
=======
	@Override
	public List<Daycare> getClosest(Visitor visitor){
		Visitor vis = read(visitor.getId());
		return daycareService.getClosestToPosition(vis.getPosition());
	}
	
	@Override
	public List<Daycare> getDaycaresForVisitor(Visitor visitor){
		Visitor vis = read(visitor.getId());
		if(vis.isVIP()) {
			return daycareService.findAll();
		} else {
			return daycareRepository.getThree();
		}
		
	}
	@Override
	public List<Visitor> readAll(){
		return (List<Visitor>) visitorRepository.findAll();
	}
	
	
>>>>>>> Stashed changes
	
}