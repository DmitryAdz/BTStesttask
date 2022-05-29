package com.odinec.springexample.service;

import java.util.List;

import com.odinec.springexample.model.StudentSurname;

public interface StudentSurnameService {

	StudentSurname findStudentSurnameById(Long id);
	List<StudentSurname> findAllStudentsSurnames();
	StudentSurname saveStudentSurname(StudentSurname studentSurname);
	void deleteStudentSurnameById(Long id);
}
