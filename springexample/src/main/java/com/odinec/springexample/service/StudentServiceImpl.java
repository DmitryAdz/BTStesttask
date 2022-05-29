package com.odinec.springexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.odinec.springexample.model.Student;
import com.odinec.springexample.repository.StudentRepositoryJPA;

@Service
public class StudentServiceImpl implements StudentService {

	private final StudentRepositoryJPA studentRepositoryJPA;
	
	@Autowired
	public StudentServiceImpl(StudentRepositoryJPA studentRepositoryJPA) {
		this.studentRepositoryJPA = studentRepositoryJPA;
	}
	
	@Override
	@Transactional
	public Student findStudentById(Long id) {
		return studentRepositoryJPA.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public List<Student> findAllStudents() {
		return studentRepositoryJPA.findAll();
	}
	
	@Override
	@Transactional
	public Student saveStudent(Student student) {
		return studentRepositoryJPA.save(student);
	}
	
	@Override
	@Transactional
	public void deleteStudentById(Long id) {
		studentRepositoryJPA.deleteById(id);
	}
}
