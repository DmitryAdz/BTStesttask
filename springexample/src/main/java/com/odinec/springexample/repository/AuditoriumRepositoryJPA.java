package com.odinec.springexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odinec.springexample.model.Auditorium;

public interface AuditoriumRepositoryJPA extends JpaRepository<Auditorium, Long>{

}
