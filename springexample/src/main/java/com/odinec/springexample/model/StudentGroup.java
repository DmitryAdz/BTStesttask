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
@Table(name = "students_groups")
public class StudentGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name_group")
	private String nameGroup;
	
	@OneToMany(mappedBy = "studentGroup", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<Student> students;
	
	@OneToMany(mappedBy = "studentGroup", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<Timetable> timetable;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameGroup() {
		return nameGroup;
	}
	public void setNameGroup(String nameGroup) {
		this.nameGroup = nameGroup;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}
