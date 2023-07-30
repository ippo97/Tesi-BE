package com.unical.solarVision.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.unical.solarVision.dto.ArduinoDetectionDTO;
import com.unical.solarVision.dto.DailyArduinoDetectionDTO;
import com.unical.solarVision.dto.GroupedArduinoDetectionDTO;

public interface ArduinoDetectionService {

	DailyArduinoDetectionDTO findAllByDay (String day);
	List<GroupedArduinoDetectionDTO> findAllByRange(String day1, String day2);
	ArduinoDetectionDTO create (ArduinoDetectionDTO dto);

}
