package com.odinec.springexample.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odinec.springexample.model.Lecture;
import com.odinec.springexample.repository.LectureRepositoryJPA;

@Service
public class LectureServiceImpl implements LectureService{

	private final LectureRepositoryJPA lectureRepositoryJPA;
	
	@Autowired
	public LectureServiceImpl(LectureRepositoryJPA lectureRepositoryJPA) {
		this.lectureRepositoryJPA = lectureRepositoryJPA;
	}
	
	@Override
	@Transactional
	public Lecture findLectureById(Long id) {
		return lectureRepositoryJPA.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public List<Lecture> findAllLecture() {
		return lectureRepositoryJPA.findAll();
	}
	
	@Override
	@Transactional
	public Lecture saveLecture(Lecture lecture) {
		return lectureRepositoryJPA.save(lecture);
	}
	
	@Override
	@Transactional
	public void deleteLectureById(Long id) {
		lectureRepositoryJPA.deleteById(id);
	}
}
