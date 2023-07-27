package com.unical.solarVision.service;

import java.time.LocalDateTime;
import java.util.List;

import com.unical.solarVision.dto.ArduinoRilevazioneDTO;

public interface ArduinoRilevazioneService {
	
	List<ArduinoRilevazioneDTO> findAllByDay (LocalDateTime day);
	List<ArduinoRilevazioneDTO> findAllByRange(LocalDateTime day1, LocalDateTime day2);
	ArduinoRilevazioneDTO create (ArduinoRilevazioneDTO dto);

}
