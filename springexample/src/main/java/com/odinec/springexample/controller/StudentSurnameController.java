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

import com.odinec.springexample.model.StudentSurname;
import com.odinec.springexample.service.StudentSurnameService;

@RestController
@RequestMapping("/api")
public class StudentSurnameController {
	
	private final StudentSurnameService studentSurnameService;
	
	@Autowired
	public StudentSurnameController(StudentSurnameService studentSurnameService) {
		this.studentSurnameService = studentSurnameService;
	}

	@GetMapping("/surname/{id}")
	public StudentSurname getStudentSurnameById(@PathVariable("id") Long id) {
		return studentSurnameService.findStudentSurnameById(id);
	}
	
	@GetMapping("/surnames")
	public List<StudentSurname> getAllStudentsSurnames() {
		return studentSurnameService.findAllStudentsSurnames();
	}
	
	@PostMapping("/surname/create")
	public ResponseEntity<Void> createStudentSurname(@RequestBody StudentSurname studentSurname) {
		if(studentSurname.getId() != null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		studentSurnameService.saveStudentSurname(studentSurname);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/surname/update")
	public ResponseEntity<Void> updateStudentSurname(@RequestBody StudentSurname studentSurname) {
		if(studentSurname.getId() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		studentSurnameService.saveStudentSurname(studentSurname);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/surname/delete/{id}")
	public void deleteStudentSurnameById(@PathVariable("id") Long id) {
		studentSurnameService.deleteStudentSurnameById(id);
	}
}
