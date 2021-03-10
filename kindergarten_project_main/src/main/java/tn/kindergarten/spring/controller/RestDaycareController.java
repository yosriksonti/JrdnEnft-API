package tn.kindergarten.spring.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.kindergarten.spring.entities.Daycare;
import tn.kindergarten.spring.entities.Favorite;
import tn.kindergarten.spring.entities.Graph;
import tn.kindergarten.spring.entities.Visitor;
import tn.kindergarten.spring.service.DaycareServiceImpl;
@RestController
public class RestDaycareController

{@Autowired
	DaycareServiceImpl daycareServiceImpl;

@GetMapping(value = "/daycares") 
@ResponseBody
	public List<Daycare> getDaycares() 
	{
	
	return daycareServiceImpl.findAll();
	}

@GetMapping(value = "/daycares/{id}") 
@ResponseBody
	public Daycare getDaycare(@PathVariable("id") int id) 
	{
	
	return daycareServiceImpl.findById(id);
	}

@GetMapping(value = "/daycares/child/{id}") 
@ResponseBody
	public Daycare getDaycareChild(@PathVariable("id") int id) 
	{
	
	return daycareServiceImpl.findById(id);
	}

@GetMapping(value = "/daycares/{id}/path") 
@ResponseBody
	public Graph getDaycarePath(@PathVariable("id") int id) 
	{
	
	return daycareServiceImpl.getShortestPathsChildren(id);
	}

@PostMapping(value = "/daycares/add") 
@ResponseBody
	public boolean addDaycare(@RequestBody Daycare daycare) 
	{
	
	return daycareServiceImpl.addDaycare(daycare);
	//return 1 ;
	}

@PutMapping(value = "/daycares/update") 
@ResponseBody
	public boolean updateDaycare(@RequestBody Daycare daycare) 
	{
	
	return daycareServiceImpl.updateDaycare(daycare);
	//return 1 ;
	}

@DeleteMapping(value = "/daycares/{id}/delete") 
@ResponseBody
	public boolean deleteDaycare(@PathVariable("id") int id) 
	{
	
	return daycareServiceImpl.deleteDaycare(id);
	}

@PutMapping(value = "/affecterDaycareFavorite/{DaycareId}") 
@ResponseBody
	public int affecterDaycareFavorite(@RequestBody Favorite favorite,@PathVariable("DaycareId") int daycareId) 
	{
	Daycare daycare = new Daycare();
	daycare.setId(daycareId);
	List<Daycare> daycares = new ArrayList<Daycare>();
	daycares.add(daycare);
	favorite.setDaycares(daycares);
	System.out.print(favorite.getId());
	return daycareServiceImpl.affecterDaycareFavoritee(favorite);
	//return 1 ;
	}

@PutMapping(value = "/supprimerDaycareFavorite/{DaycareId}") 
@ResponseBody
	public int supprimerDaycareFavorite(@RequestBody Favorite favorite,@PathVariable("DaycareId") int daycareId) 
	{
	Daycare daycare = new Daycare();
	daycare.setId(daycareId);
	List<Daycare> daycares = new ArrayList<Daycare>();
	daycares.add(daycare);
	favorite.setDaycares(daycares);
	System.out.print(favorite.getId());
	return daycareServiceImpl.supprimerDaycareFavoritee(favorite);
	//return 1 ;
	}

@GetMapping(value = "/DaycareFavorite/{favoriteId}") 
@ResponseBody
	public Favorite getFavorite(@PathVariable("favoriteId") int favoriteId) 
	{
	
	return daycareServiceImpl.getFavoriteeById(favoriteId);
	//return 1 ;
	}
}

