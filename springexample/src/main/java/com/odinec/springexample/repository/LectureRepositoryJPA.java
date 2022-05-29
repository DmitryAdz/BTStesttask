package com.odinec.springexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odinec.springexample.model.Lecture;

public interface LectureRepositoryJPA extends JpaRepository<Lecture, Long>{

}
