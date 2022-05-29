package com.odinec.springexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odinec.springexample.model.WorkingDay;

public interface WorkingDayRepositoryJPA extends JpaRepository<WorkingDay, Long>{

}
