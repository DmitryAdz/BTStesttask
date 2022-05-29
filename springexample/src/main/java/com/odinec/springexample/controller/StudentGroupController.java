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

import com.odinec.springexample.model.StudentGroup;
import com.odinec.springexample.service.StudentGroupService;

@RestController
@RequestMapping("/api")
public class StudentGroupController {

	private final StudentGroupService studentGroupService;
	
	@Autowired
	public StudentGroupController(StudentGroupService studentGroupService) {
		this.studentGroupService = studentGroupService;
	}
	
	@GetMapping("/group/{id}")
	public StudentGroup getStudentGroupById(@PathVariable("id") Long id) {
		return studentGroupService.findStudentGroupById(id);
	}
	
	@GetMapping("/groups")
	public List<StudentGroup> getAllStudentsGroups() {
		return studentGroupService.findAllStudentsGroups();
	}
	
	@PostMapping("/group/create")
	public ResponseEntity<Void> createStudentGroup(@RequestBody StudentGroup studentGroup) {
		if(studentGroup.getId() != null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		studentGroupService.saveStudentGroup(studentGroup);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/group/update")
	public ResponseEntity<Void> updateStudentGroup(@RequestBody StudentGroup studentGroup) {
		if(studentGroup.getId() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		studentGroupService.saveStudentGroup(studentGroup);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/group/delete/{id}")
	public void deleteStudentGroupById(@PathVariable("id") Long id) {
		studentGroupService.deleteStudentGroupById(id);
	}
}
