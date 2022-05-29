package com.odinec.springexample.service;

import java.util.List;

import com.odinec.springexample.model.Student;

public interface StudentService {

	Student findStudentById(Long id);
	List<Student> findAllStudents();
	Student saveStudent(Student student);
	void deleteStudentById(Long id);
}
