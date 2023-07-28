package com.unical.solarVision.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.unical.solarVision.dto.ArduinoDetectionDTO;

public interface ArduinoDetectionService {
	
	List<ArduinoDetectionDTO> findAllByDay (String day);
	List<ArduinoDetectionDTO> findAllByRange(String day1, String day2);
	ArduinoDetectionDTO create (ArduinoDetectionDTO dto);

}
