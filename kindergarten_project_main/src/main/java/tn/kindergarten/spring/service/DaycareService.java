package tn.kindergarten.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.spring.entities.Daycare;
import tn.kindergarten.spring.repository.DaycareRepository;
@Service
public class DaycareService implements IDaycareService{
	
	@Autowired
	DaycareRepository daycareRepository;

	@Override
	public boolean addDaycare(Daycare daycare) {
		daycareRepository.save(daycare);
		return true;
	}

	@Override
	public boolean deleteDaycare(int id) {
		daycareRepository.delete(daycareRepository.findById(id).get());
		return true;
	}

	@Override
	public boolean updateLogoDaycare(Daycare daycare, int id) {
		Daycare tmp = daycareRepository.findById(id).get();
		tmp.setLogo(daycare.getLogo());
		daycareRepository.save(tmp);
		return true;
	}

	@Override
	public Daycare findByid(int id) {
		return daycareRepository.findById(id).get();
	}

	@Override
	public List<Daycare> findAll() {
		 List<Daycare> tmp = (List<Daycare>) daycareRepository.findAll();
		 return tmp;
	}

}
