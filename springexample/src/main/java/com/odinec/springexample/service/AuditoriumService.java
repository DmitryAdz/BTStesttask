package com.odinec.springexample.service;

import java.util.List;

import com.odinec.springexample.model.Auditorium;

public interface AuditoriumService {

	Auditorium findAuditoriumById(Long id);
	List<Auditorium> findAllAuditorium();
	Auditorium saveAuditorium(Auditorium auditorium);
	void deleteAuditoriumById(Long id);
}
