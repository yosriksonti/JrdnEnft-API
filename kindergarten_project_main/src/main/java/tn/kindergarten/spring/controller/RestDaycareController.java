package tn.kindergarten.spring.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.kindergarten.spring.entities.Daycare;
import tn.kindergarten.spring.entities.Favorite;
import tn.kindergarten.spring.entities.Visitor;
import tn.kindergarten.spring.service.DaycareServiceImpl;
@RestController
public class RestDaycareController

{@Autowired
	DaycareServiceImpl daycareServiceImpl;
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

