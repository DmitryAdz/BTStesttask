package com.odinec.springexample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "timetable")
public class Timetable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_day")
	private WorkingDay workingDay;
	
	@ManyToOne
	@JoinColumn(name = "id_lecture")
	private Lecture lecture;
	
	@ManyToOne
	@JoinColumn(name = "id_group")
	private StudentGroup studentGroup;
	
	@ManyToOne
	@JoinColumn(name = "id_auditorium")
	private Auditorium auditorium;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public WorkingDay getWorkingDay() {
		return workingDay;
	}
	public void setWorkingDay(WorkingDay workingDay) {
		this.workingDay = workingDay;
	}
	public Lecture getLecture() {
		return lecture;
	}
	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}
	public StudentGroup getStudentGroup() {
		return studentGroup;
	}
	public void setStudentGroup(StudentGroup studentGroup) {
		this.studentGroup = studentGroup;
	}
	public Auditorium getAuditorium() {
		return auditorium;
	}
	public void setAuditorium(Auditorium auditorium) {
		this.auditorium = auditorium;
	}
}
