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
@Table(name = "auditorium")
public class Auditorium {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "numb_auditorium")
	private int numbAuditorium;
	
	@OneToMany(mappedBy = "auditorium", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<Timetable> timetable;
	
	public Auditorium() {
		
	}
	
	public Auditorium(Long id, int numbAuditorium) {
		this.id = id;
		this.numbAuditorium = numbAuditorium;
	}
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumbAuditorium() {
		return numbAuditorium;
	}
	public void setNumbAuditorium(int numbAuditorium) {
		this.numbAuditorium = numbAuditorium;
	}
	public Set<Timetable> getTimetable() {
		return timetable;
	}
	public void setTimetable(Set<Timetable> timetable) {
		this.timetable = timetable;
	}
	
}
