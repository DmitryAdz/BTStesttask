package com.odinec.springexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.odinec.springexample.model.StudentGroup;
import com.odinec.springexample.repository.StudentGroupRepositoryJPA;

@Service
public class StudentGroupServiceImpl implements StudentGroupService {

	private final StudentGroupRepositoryJPA studentGroupRepositoryJPA;
	
	@Autowired
	public StudentGroupServiceImpl(StudentGroupRepositoryJPA studentGroupRepositoryJPA) {
		this.studentGroupRepositoryJPA = studentGroupRepositoryJPA;
	}
	
	@Override
	@Transactional
	public StudentGroup findStudentGroupById(Long id) {
		return studentGroupRepositoryJPA.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public List<StudentGroup> findAllStudentsGroups() {
		return studentGroupRepositoryJPA.findAll();
	}
	
	@Override
	@Transactional
	public StudentGroup saveStudentGroup(StudentGroup studentGroup) {
		return studentGroupRepositoryJPA.save(studentGroup);
	}
	
	@Override
	@Transactional
	public void deleteStudentGroupById(Long id) {
		studentGroupRepositoryJPA.deleteById(id);
	}
}
