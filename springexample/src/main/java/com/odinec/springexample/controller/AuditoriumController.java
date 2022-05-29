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

import com.odinec.springexample.model.Auditorium;
import com.odinec.springexample.service.AuditoriumService;

@RestController
@RequestMapping("/api")
public class AuditoriumController {

	private final AuditoriumService auditoriumService;
	
	@Autowired
	public AuditoriumController(AuditoriumService auditoriumService) {
		this.auditoriumService = auditoriumService;
	}
	
	@GetMapping("/auditorium/{id}")
	public Auditorium getAuditoriumById(@PathVariable("id") Long id) {
		return auditoriumService.findAuditoriumById(id);
	}
	
	@GetMapping("/auditorium")
	public List<Auditorium> getAllAuditorium() {
		return auditoriumService.findAllAuditorium();
	}
	
	@PostMapping("/auditorium/create")
	public ResponseEntity<Void> createAuditorium(@RequestBody Auditorium auditorium) {
		if(auditorium.getId() != null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		auditoriumService.saveAuditorium(auditorium);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/auditorium/update")
	public ResponseEntity<Void> updateAuditorium(@RequestBody Auditorium auditorium) {
		if(auditorium.getId() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		auditoriumService.saveAuditorium(auditorium);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/auditorium/delete/{id}")
	public void deleteAuditoriumById(@PathVariable("id") Long id) {
		auditoriumService.deleteAuditoriumById(id);
	}
}
