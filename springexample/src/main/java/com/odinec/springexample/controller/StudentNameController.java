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

import com.odinec.springexample.model.StudentName;
import com.odinec.springexample.service.StudentNameService;

@RestController
@RequestMapping("/api")
public class StudentNameController {
	
	private final StudentNameService studentNameService;
	
	@Autowired
	public StudentNameController(StudentNameService studentNameService) {
		this.studentNameService = studentNameService;
	}
	
	@GetMapping("/name/{id}")
	public StudentName getStudentNameById(@PathVariable("id") Long id) {
		return studentNameService.findStudentNameById(id);
	}
	
	@GetMapping("/names")
	public List<StudentName> getAllStudentsNames() {
		return studentNameService.findAllStudentsNames();
	}
	
	@PostMapping("/name/create")
	public ResponseEntity<Void> createStudentName(@RequestBody StudentName studentName) {
		if(studentName.getId() != null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		studentNameService.saveStudentName(studentName);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/name/update")
	public ResponseEntity<Void> updateStudentName(@RequestBody StudentName studentName) {
		if(studentName.getId() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		studentNameService.saveStudentName(studentName);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/name/delete/{id}")
	public void deleteStudentNameById(@PathVariable("id") Long id) {
		studentNameService.deleteStudentNameById(id);
	}
}
