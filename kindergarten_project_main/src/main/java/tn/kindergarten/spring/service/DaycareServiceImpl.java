package tn.kindergarten.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.ArrayUtils;

import tn.kindergarten.spring.entities.Daycare;
import tn.kindergarten.spring.entities.Favorite;
import tn.kindergarten.spring.repository.DaycareRepository;
import tn.kindergarten.spring.repository.FavoriteRepository;
@Service
public class DaycareServiceImpl implements IDaycareService 
{
	
	
	@Autowired
	DaycareRepository daycareRepository;
    @Autowired
    FavoriteRepository favoriteRepository;
	public int affecterDaycareFavoritee(Favorite favorite) 
	{
		Daycare daycare = favorite.getDaycares().get(0);
		Daycare daycareManagerEntity = daycareRepository.findById(favorite.getDaycares().get(0).getId()).get();
		Favorite favoriteManagedEntity = favoriteRepository.findById(favorite.getId()).get();

		if(favoriteManagedEntity.getDaycares()== null)
		{

			List<Daycare> daycares = new ArrayList<>();
			daycares.add(daycareManagerEntity);
			favoriteManagedEntity.setDaycares(daycares);
		}
		else
		{
			List<Daycare> daycares = favoriteManagedEntity.getDaycares();
			daycares.add(daycareManagerEntity);
			favoriteManagedEntity.setDaycares(daycares);

		}
		favoriteRepository.save(favoriteManagedEntity);
        return 1 ;
	}
	public int supprimerDaycareFavoritee(Favorite favorite) 
	{
		Daycare daycare = favorite.getDaycares().get(0);
		Daycare daycareManagerEntity = daycareRepository.findById(favorite.getDaycares().get(0).getId()).get();
		Favorite favoriteManagedEntity = favoriteRepository.findById(favorite.getId()).get();

		if(!(favoriteManagedEntity.getDaycares()== null))
		{

			List<Daycare> daycares = favoriteManagedEntity.getDaycares();
			int index = -1;
			for(Daycare dc : daycares) {
				index ++;
				if(dc.getId() == daycareManagerEntity.getId() ) {
					break;
				}
			}
			System.out.println(index);
			daycares.remove(index);
			favoriteManagedEntity.setDaycares(daycares);

		}
		favoriteRepository.save(favoriteManagedEntity);
        return 1;
	}
	
	public Favorite getFavoriteeById(int id) 
	{
		
		return favoriteRepository.findById(id).get();

	
	}
}
