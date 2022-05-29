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

import com.odinec.springexample.model.Timetable;
import com.odinec.springexample.service.TimetableService;

@RestController
@RequestMapping("/api")
public class TimetableController {

	private final TimetableService timetableService;
	
	@Autowired
	public TimetableController(TimetableService timetableService) {
		this.timetableService = timetableService;
	}
	
	@GetMapping("/timetable/{id}")
	public Timetable getTimetableById(@PathVariable("id") Long id) {
		return timetableService.findTimetableById(id);
	}
	
	@GetMapping("/timetables")
	public List<Timetable> getAllTimetables() {
		return timetableService.findAllTimetables();
	}
	
	@PostMapping("/timetable/create")
	public ResponseEntity<Void> createTimetable(@RequestBody Timetable timetable) {
		if(timetable.getId() != null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		timetableService.saveTimetable(timetable);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/timetable/update")
	public ResponseEntity<Void> updateTimetable(@RequestBody Timetable timetable) {
		if(timetable.getId() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		timetableService.saveTimetable(timetable);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/timetable/delete/{id}")
	public void deleteTimetableById(@PathVariable("id") Long id) {
		timetableService.deleteTimetableById(id);
	}
	
	@GetMapping("/timetable/byday/{id}")
	public List<Timetable> getTimetableByDayId(@PathVariable("id") Long id) {
		return timetableService.findTimetableByDay(id);
	}
	
	@GetMapping("/timetable/bydayandstudent/{idday}/{idstudent}")
	public List<Timetable> getTimetableByDayIdAndStudentId(@PathVariable("idday") Long idDay, 
														   @PathVariable("idstudent") Long idStudent) {
		return timetableService.findTimetableByDayAndStudent(idDay, idStudent);
	}
	
}
