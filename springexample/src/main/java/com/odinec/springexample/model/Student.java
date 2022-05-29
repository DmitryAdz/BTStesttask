package com.odinec.springexample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_surname")
	private StudentSurname studentSurname;
	
	@ManyToOne
	@JoinColumn(name = "id_name")
	private StudentName studentName;
	
	@ManyToOne
	@JoinColumn(name = "id_group")
	private StudentGroup studentGroup;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public StudentSurname getStudentSurname() {
		return studentSurname;
	}
	public void setStudentSurname(StudentSurname studentSurname) {
		this.studentSurname = studentSurname;
	}
	public StudentName getStudentName() {
		return studentName;
	}
	public void setStudentName(StudentName studentName) {
		this.studentName = studentName;
	}
	public StudentGroup getStudentGroup() {
		return studentGroup;
	}
	public void setStudentGroup(StudentGroup studentGroup) {
		this.studentGroup = studentGroup;
	}
}
