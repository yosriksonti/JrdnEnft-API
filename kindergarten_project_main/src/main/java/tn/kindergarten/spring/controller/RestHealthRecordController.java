package tn.kindergarten.spring.controller;

import java.util.Date;
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

import tn.kindergarten.spring.entities.HealthRecord;
import tn.kindergarten.spring.entities.Parent;
import tn.kindergarten.spring.service.IHealthRecordService;

@RestController
public class RestHealthRecordController {
	
	@Autowired 
	IHealthRecordService iHealthRecordService;
	
	
	
	@PostMapping("/addHealthRecord")
	@ResponseBody
	public HealthRecord ajouterHealthRecord(@RequestBody HealthRecord HealthRecord)
	{
		iHealthRecordService.addHealthRecord(HealthRecord);
		return HealthRecord;
	}
	
	@DeleteMapping("/deleteHealthRecord/{id}")
	@ResponseBody
	public int deleteHealthRecord(@PathVariable("id") int id )
	{
		iHealthRecordService.DeleteHealthRecordById(id);
		return id;
	}
	
	@GetMapping("/HealthRecord/{id}")
	@ResponseBody
	public HealthRecord findHealthRecord(@PathVariable("id") int id )
	{
		return iHealthRecordService.findHealthRecord(id);
	}
	
	@GetMapping(value = "/getAllHealthRecords")
    @ResponseBody
	public List<HealthRecord> getAllHealthRecords() {
		
		return iHealthRecordService.getAllHealthRecords();
	}
	
	@GetMapping(value = "/getAllHealthRecordsParents")
	  @ResponseBody
		public List<Parent> getAllParents() {
			
			return iHealthRecordService.getAllParentsJPQL();
		}
		
	@PutMapping(value = "/ModifyHealthRecordById/{id}/{docavBool}/{dateBegin}/{dateEnd}")
	@ResponseBody
	public void ModifyHealthRecordById(@PathVariable("id") int id ,@PathVariable("docavBool") Boolean docavBool ,@PathVariable("AppointDate") Date AppointDate ,@PathVariable("description") String description , @PathVariable("etat") String etat,@PathVariable("images") String images )
	{
		iHealthRecordService.ModifyHealthRecordById(id, AppointDate, description, etat, images);
	}
	

}
