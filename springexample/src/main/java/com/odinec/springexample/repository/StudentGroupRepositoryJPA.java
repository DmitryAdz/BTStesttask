package com.odinec.springexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odinec.springexample.model.StudentGroup;

public interface StudentGroupRepositoryJPA extends JpaRepository<StudentGroup, Long>{

}
