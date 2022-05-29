package com.odinec.springexample.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odinec.springexample.model.Timetable;
import com.odinec.springexample.repository.TimetableRepositoryJPA;

@Service
public class TimetableServiceImpl implements TimetableService{
	
	private final TimetableRepositoryJPA timetableRepositoryJPA;
	
	@Autowired
	public TimetableServiceImpl(TimetableRepositoryJPA timetableRepositoryJPA) {
		this.timetableRepositoryJPA = timetableRepositoryJPA;
	}
	
	@Override
	@Transactional
	public Timetable findTimetableById(Long id) {
		return timetableRepositoryJPA.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public List<Timetable> findAllTimetables(){
		return timetableRepositoryJPA.findAll();
	}
	
	@Override
	@Transactional
	public Timetable saveTimetable(Timetable timetable) {
		return timetableRepositoryJPA.save(timetable);
	}
	
	@Override
	@Transactional
	public void deleteTimetableById(Long id) {
		timetableRepositoryJPA.deleteById(id);
	}
	
	@Override
	@Transactional
	public List<Timetable> findTimetableByDay(Long id) {
		return timetableRepositoryJPA.findTimetableByDay(id);
	}
	
	@Override
	@Transactional
	public List<Timetable> findTimetableByDayAndStudent(Long idDay, Long idSTudent) {
		return timetableRepositoryJPA.findTimetableByDayAndStudent(idDay, idSTudent);
	}
}
