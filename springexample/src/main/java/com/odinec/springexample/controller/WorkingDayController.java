package com.odinec.springexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odinec.springexample.model.WorkingDay;
import com.odinec.springexample.service.WorkingDayService;

@RestController
@RequestMapping("/api")
public class WorkingDayController {

	private final WorkingDayService workingDayService;
	
	@Autowired
	public WorkingDayController(WorkingDayService workingDayService) {
		this.workingDayService = workingDayService;
	}
	
	@GetMapping("/workingday/{id}")
	public WorkingDay getWorkingdayById(@PathVariable("id") Long id) {
		return workingDayService.findWorkingDayById(id);
	}
	
	@GetMapping("/workingdays")
	public List<WorkingDay> getAllWorkingdays() {
		return workingDayService.findAllWorkingDays();
	}
	
	@PostMapping("/workingday/create")
	public ResponseEntity<Void> createWorkingDay(@RequestBody WorkingDay workingDay) {
		if(workingDay.getId() != null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		workingDayService.saveWorkingDay(workingDay);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/workingday/update")
	public ResponseEntity<Void> updateWorkingDay(@RequestBody WorkingDay workingDay) {
		if(workingDay.getId() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		workingDayService.saveWorkingDay(workingDay);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/workingday/delete/{id}")
	public void deleteWorkingDay(@PathVariable("id") Long id) {
		workingDayService.deleteWorkingDayById(id);
	}
}
