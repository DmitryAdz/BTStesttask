package com.odinec.springexample.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.odinec.springexample.model.Auditorium;
import com.odinec.springexample.repository.AuditoriumRepositoryJPA;

@SpringBootTest
public class AuditoruimServiceTests {

	@MockBean
	private AuditoriumRepositoryJPA auditoriumRepositoryJPA;
	
	private final AuditoriumService auditoriumService;
	@Autowired
	public AuditoruimServiceTests(AuditoriumService auditoriumService) {
		this.auditoriumService = auditoriumService;
	}
	
	@Test
	public void testFindAuditoriumById() {
		System.out.println("testFindAuditoriumById()");
		Auditorium auditoriumExpected = new Auditorium(42L, 3);
		when(auditoriumRepositoryJPA.findById(42L)).thenReturn(Optional.of(auditoriumExpected));
		Auditorium auditorium = auditoriumService.findAuditoriumById(42L);
		assertEquals(auditoriumExpected, auditorium);
	}
	
	@Test
	public void testFindAllAuditorium() {
		System.out.println("testFindAllAuditorium()");
		List<Auditorium> usersFromMock = new ArrayList<Auditorium>();
        when(auditoriumRepositoryJPA.findAll()).thenReturn(usersFromMock);
        List<Auditorium> users = auditoriumService.findAllAuditorium();
    	assertEquals(users,usersFromMock);
	}
}
