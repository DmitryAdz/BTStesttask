package com.odinec.springexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.odinec.springexample.model.WorkingDay;
import com.odinec.springexample.repository.WorkingDayRepositoryJPA;

@Service
public class WorkingDayServiceImpl implements WorkingDayService {

	private final WorkingDayRepositoryJPA workingDayRepositoryJPA;
	
	@Autowired
	public WorkingDayServiceImpl(WorkingDayRepositoryJPA workingDayRepositoryJPA) {
		this.workingDayRepositoryJPA = workingDayRepositoryJPA;
	}
	
	@Override
	@Transactional
	public WorkingDay findWorkingDayById(Long id) {
		return workingDayRepositoryJPA.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public List<WorkingDay> findAllWorkingDays() {
		return workingDayRepositoryJPA.findAll();
	}
	
	@Override
	@Transactional
	public WorkingDay saveWorkingDay(WorkingDay workingDay) {
		return workingDayRepositoryJPA.save(workingDay);
	}
	
	@Override
	@Transactional
	public void deleteWorkingDayById(Long id) {
		workingDayRepositoryJPA.deleteById(id);
	}
}
