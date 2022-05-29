package com.odinec.springexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odinec.springexample.model.Student;

public interface StudentRepositoryJPA extends JpaRepository<Student, Long>{

}
