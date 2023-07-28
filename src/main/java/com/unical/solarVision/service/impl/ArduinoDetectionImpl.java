package com.unical.solarVision.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.unical.solarVision.dto.ArduinoDetectionDTO;
import com.unical.solarVision.mapper.ArduinoDetectionMapper;
import com.unical.solarVision.model.ArduinoDetection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unical.solarVision.repository.ArduinoDetectionRepository;
import com.unical.solarVision.service.ArduinoDetectionService;

@Component
public class ArduinoDetectionImpl implements ArduinoDetectionService {
	@Autowired
	ArduinoDetectionRepository repository;

	@Override
	public List<ArduinoDetectionDTO> findAllByDay(String day) {
		List<ArduinoDetection> list = repository.findAll();
		List<ArduinoDetection> result = new ArrayList<>();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(day, formatter);
		for (ArduinoDetection ad : list) {
			if(ad.getDate().toLocalDate().equals(localDate)){
				result.add(ad);
			}
		}
		return ArduinoDetectionMapper.INSTANCE.toArduinoDetectionDTOList(result);

	}

	@Override
	public List<ArduinoDetectionDTO> findAllByRange(String day1, String day2) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate1 = LocalDate.parse(day1, formatter);
		LocalDate localDate2 = LocalDate.parse(day2, formatter);
		List<ArduinoDetection> list = repository.findAll();
		List<ArduinoDetection> result = new ArrayList<>();
		for (ArduinoDetection ad : list) {
			LocalDate date = ad.getDate().toLocalDate();
			if(!date.isBefore(localDate1) && !date.isAfter(localDate2) ){
				result.add(ad);
			}
		}
		return ArduinoDetectionMapper.INSTANCE.toArduinoDetectionDTOList(result);
	}

	@Override
	public ArduinoDetectionDTO create(ArduinoDetectionDTO dto) {
		ArduinoDetection entity = ArduinoDetectionMapper.INSTANCE.toArduinoDetectionEntity(dto);
		entity.setDate(LocalDateTime.now());
		repository.save(entity);
		return dto;
	}

}
