package tn.kindergarten.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.kindergarten.spring.entities.HealthRecord;
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
	public List<HealthRecord> getAllEmployes() {
		
		return iHealthRecordService.getAllHealthRecords();
	}

}
