package com.unical.solarVision.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unical.solarVision.dto.ArduinoRilevazioneDTO;
import com.unical.solarVision.mapper.ArduinoRilevazioneMapper;
import com.unical.solarVision.model.ArduinoRilevazione;
import com.unical.solarVision.repository.ArduinoRilevazioneRepository;
import com.unical.solarVision.service.ArduinoRilevazioneService;

@Component
public class ArduinoRilevazioneImpl implements ArduinoRilevazioneService{
	@Autowired
	ArduinoRilevazioneRepository repository;
	
	@Autowired
	public List<ArduinoRilevazioneDTO> findAllByDay(LocalDateTime day) {
		// TODO Auto-generated method stub
		return null;
	}

	@Autowired
	public List<ArduinoRilevazioneDTO> findAllByRange(LocalDateTime day1, LocalDateTime day2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Autowired
	public ArduinoRilevazioneDTO create(ArduinoRilevazioneDTO dto) {		
		
		return null;
	}

}
