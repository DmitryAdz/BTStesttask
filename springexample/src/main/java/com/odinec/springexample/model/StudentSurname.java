package com.odinec.springexample.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "students_surnames")
public class StudentSurname {

	@Id
	@GeneratedValue()
	private Long id;
	
	@Column(name = "surname")
	private String surname;
	
	@OneToMany(mappedBy = "studentSurname", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<Student> students;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}
