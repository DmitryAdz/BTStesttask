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

import com.odinec.springexample.model.Lecture;
import com.odinec.springexample.service.LectureService;

@RestController
@RequestMapping("/api")
public class LectureController {
	
	private final LectureService lectureService;
	
	@Autowired
	public LectureController(LectureService lectureService) {
		this.lectureService = lectureService;
	}
	
	@GetMapping("/lecture/{id}")
	public Lecture getLectureById(@PathVariable("id") Long id) {
		return lectureService.findLectureById(id);
	}

	@GetMapping("/lectures")
	public List<Lecture> getAllLectures() {
		return lectureService.findAllLecture();
	}
	
	@PostMapping("/lecture/create")
	public ResponseEntity<Void> createLecture(@RequestBody Lecture lecture) {
		if(lecture.getId() != null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		lectureService.saveLecture(lecture);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/lecture/update")
	public ResponseEntity<Void> updateLecture(@RequestBody Lecture lecture) {
		if(lecture.getId() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		lectureService.saveLecture(lecture);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/lecture/delete/{id}")
	public void deleteLectureById(@PathVariable("id") Long id) {
		lectureService.deleteLectureById(id);
	}
}
