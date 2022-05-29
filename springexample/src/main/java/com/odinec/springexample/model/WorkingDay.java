package com.odinec.springexample.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "working_days")
public class WorkingDay {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "working_day")
	private String workingDay;
	
	@OneToMany(mappedBy = "workingDay", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<Timetable> timetable;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getWorkingDay() {
		return workingDay;
	}
	public void setWorkingDay(String workingDay) {
		this.workingDay = workingDay;
	}
	public Set<Timetable> getTimetable() {
		return timetable;
	}
	public void setTimetable(Set<Timetable> timetable) {
		this.timetable = timetable;
	}
}
