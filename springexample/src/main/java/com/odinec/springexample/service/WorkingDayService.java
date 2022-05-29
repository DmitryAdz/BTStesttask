package com.odinec.springexample.service;

import java.util.List;

import com.odinec.springexample.model.WorkingDay;

public interface WorkingDayService {

	WorkingDay findWorkingDayById(Long id);
	List<WorkingDay> findAllWorkingDays();
	WorkingDay saveWorkingDay(WorkingDay workingDay);
	void deleteWorkingDayById(Long id);
}
