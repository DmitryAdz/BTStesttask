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

import com.odinec.springexample.model.Student;
import com.odinec.springexample.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	private final StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable("id") Long id) {
		return studentService.findStudentById(id);
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return studentService.findAllStudents();
	}
	
	@PostMapping("/student/create")
	public ResponseEntity<Void> createStudent(@RequestBody Student student) {
		if(student.getId() != null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		studentService.saveStudent(student);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/student/update")
	public ResponseEntity<Void> updateStudent(@RequestBody Student student) {
		if(student.getId() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		studentService.saveStudent(student);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/student/delete/{id}")
	public void deleteStudentById(@PathVariable("id") Long id) {
		studentService.deleteStudentById(id);
	}
}
