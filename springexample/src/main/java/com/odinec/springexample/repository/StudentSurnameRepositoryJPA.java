package com.odinec.springexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odinec.springexample.model.StudentSurname;

public interface StudentSurnameRepositoryJPA extends JpaRepository<StudentSurname, Long>{

}
