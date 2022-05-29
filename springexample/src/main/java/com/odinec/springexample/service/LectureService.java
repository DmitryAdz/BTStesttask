package com.odinec.springexample.service;

import java.util.List;

import com.odinec.springexample.model.Lecture;

public interface LectureService {

	Lecture findLectureById(Long id);
	List<Lecture> findAllLecture();
	Lecture saveLecture(Lecture lecture);
	void deleteLectureById(Long id);
}
