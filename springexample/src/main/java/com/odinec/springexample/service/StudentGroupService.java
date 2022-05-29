package com.odinec.springexample.service;

import java.util.List;

import com.odinec.springexample.model.StudentGroup;

public interface StudentGroupService {

	StudentGroup findStudentGroupById(Long id);
	List<StudentGroup> findAllStudentsGroups();
	StudentGroup saveStudentGroup(StudentGroup studentGroup);
	void deleteStudentGroupById(Long id);
}
