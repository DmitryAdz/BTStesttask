package com.odinec.springexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.odinec.springexample.model.StudentSurname;
import com.odinec.springexample.repository.StudentSurnameRepositoryJPA;

@Service
public class StudentSurnameServiceImpl implements StudentSurnameService {

	private final StudentSurnameRepositoryJPA studentSurnameRepositoryJPA;
	
	@Autowired
	public StudentSurnameServiceImpl(StudentSurnameRepositoryJPA studentSurnameRepositoryJPA) {
		this.studentSurnameRepositoryJPA = studentSurnameRepositoryJPA;
	}
	
	@Override
	@Transactional
	public StudentSurname findStudentSurnameById(Long id) {
		return studentSurnameRepositoryJPA.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public List<StudentSurname> findAllStudentsSurnames() {
		return studentSurnameRepositoryJPA.findAll();
	}
	
	@Override
	@Transactional
	public StudentSurname saveStudentSurname(StudentSurname studentSurname) {
		return studentSurnameRepositoryJPA.save(studentSurname);
	}
	
	@Override
	@Transactional
	public void deleteStudentSurnameById(Long id) {
		studentSurnameRepositoryJPA.deleteById(id);
	}
}
