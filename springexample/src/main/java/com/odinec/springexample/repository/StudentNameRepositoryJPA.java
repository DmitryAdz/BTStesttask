package com.odinec.springexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odinec.springexample.model.StudentName;

public interface StudentNameRepositoryJPA extends JpaRepository<StudentName, Long>{

}
