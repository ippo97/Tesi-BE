package com.unical.solarVision.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.unical.solarVision.dto.ArduinoDetectionDTO;

public interface ArduinoDetectionService {
	
	List<ArduinoDetectionDTO> findAllByDay (LocalDate day);
	List<ArduinoDetectionDTO> findAllByRange(LocalDate day1, LocalDate day2);
	ArduinoDetectionDTO create (ArduinoDetectionDTO dto);

}
