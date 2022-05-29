package com.odinec.springexample.service;

import java.util.List;

import com.odinec.springexample.model.StudentName;

public interface StudentNameService {

	StudentName findStudentNameById(Long id);
	List<StudentName> findAllStudentsNames();
	StudentName saveStudentName(StudentName studentName);
	void deleteStudentNameById(Long id);
}
