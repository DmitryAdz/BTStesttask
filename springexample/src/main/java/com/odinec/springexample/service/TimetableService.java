package com.odinec.springexample.service;

import java.util.List;

import com.odinec.springexample.model.Timetable;

public interface TimetableService {

	Timetable findTimetableById(Long id);
	List<Timetable> findAllTimetables();
	Timetable saveTimetable(Timetable timetable);
	void deleteTimetableById(Long id);
	
	List<Timetable> findTimetableByDay(Long id);
	List<Timetable> findTimetableByDayAndStudent(Long idDay, Long idSTudent);
}
