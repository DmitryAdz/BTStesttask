package com.odinec.springexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.odinec.springexample.model.StudentName;
import com.odinec.springexample.repository.StudentNameRepositoryJPA;

@Service
public class StudentNameServiceImpl implements StudentNameService {

	private final StudentNameRepositoryJPA studentNameRepositoryJPA;
	
	@Autowired
	public StudentNameServiceImpl(StudentNameRepositoryJPA studentNameRepositoryJPA) {
		this.studentNameRepositoryJPA = studentNameRepositoryJPA;
	}
	
	@Override
	@Transactional
	public StudentName findStudentNameById(Long id) {
		return studentNameRepositoryJPA.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public List<StudentName> findAllStudentsNames(){
		return studentNameRepositoryJPA.findAll();
	}
	
	@Override
	@Transactional
	public StudentName saveStudentName(StudentName studentName) {
		return studentNameRepositoryJPA.save(studentName);
	}
	
	@Override
	@Transactional
	public void deleteStudentNameById(Long id) {
		studentNameRepositoryJPA.deleteById(id);
	}
}
