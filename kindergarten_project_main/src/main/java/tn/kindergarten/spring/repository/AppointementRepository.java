package tn.kindergarten.spring.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.kindergarten.spring.entities.Appointement;
@Repository
public interface AppointementRepository extends CrudRepository<Appointement, Integer> {
	
	@Query("select a.maneger  , a.date,a.shift from Appointement a where maneger_id=:id and date>=:date")
    public List<Appointement> getAppointementByIdDate(@Param("id")int id,@Param ("date") Date date);
}
