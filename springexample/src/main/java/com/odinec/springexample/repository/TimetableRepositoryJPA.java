package com.odinec.springexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.odinec.springexample.model.Timetable;

public interface TimetableRepositoryJPA extends JpaRepository<Timetable, Long>{

	@Query(value = "SELECT * FROM timetable WHERE id_day=?1", nativeQuery = true)
	List<Timetable> findTimetableByDay(Long id);
	
	@Query(value = "SELECT * FROM timetable WHERE id_day=?1 AND id_group=(SELECT id_group FROM students WHERE id=?2);", nativeQuery = true)
	List<Timetable> findTimetableByDayAndStudent(Long idDay, Long idSTudent);
	
}
