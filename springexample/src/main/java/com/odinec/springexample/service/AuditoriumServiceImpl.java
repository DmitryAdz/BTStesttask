package com.odinec.springexample.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odinec.springexample.model.Auditorium;
import com.odinec.springexample.repository.AuditoriumRepositoryJPA;

@Service
public class AuditoriumServiceImpl implements AuditoriumService{

	private final AuditoriumRepositoryJPA auditoriumRepositoryJPA;
	
	@Autowired
	public AuditoriumServiceImpl(AuditoriumRepositoryJPA auditoriumRepositoryJPA) {
		this.auditoriumRepositoryJPA = auditoriumRepositoryJPA;
	}
	
	@Override
	@Transactional
	public Auditorium findAuditoriumById(Long id) {
		return auditoriumRepositoryJPA.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public List<Auditorium> findAllAuditorium() {
		return auditoriumRepositoryJPA.findAll();
	}
	
	@Override
	@Transactional
	public Auditorium saveAuditorium(Auditorium auditorium) {
		return auditoriumRepositoryJPA.save(auditorium);
	}
	
	@Override
	@Transactional
	public void deleteAuditoriumById(Long id) {
		auditoriumRepositoryJPA.deleteById(id);
	}
}
