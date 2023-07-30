package com.unical.solarVision.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import com.unical.solarVision.dto.ArduinoDetectionDTO;
import com.unical.solarVision.dto.DailyArduinoDetectionDTO;
import com.unical.solarVision.dto.GroupedArduinoDetectionDTO;
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
	public DailyArduinoDetectionDTO findAllByDay(String day) {
		List<ArduinoDetection> list = repository.findAll();
		List<ArduinoDetection> arduinoDetectionList = new ArrayList<>();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(day, formatter);
		for (ArduinoDetection ad : list) {
			if(ad.getDate().toLocalDate().equals(localDate)){
				arduinoDetectionList.add(ad);
			}
		}
		DailyArduinoDetectionDTO result = new DailyArduinoDetectionDTO();
		result.setDay(localDate);
		result.setDetections(ArduinoDetectionMapper.INSTANCE.toArduinoDetectionDTOList(arduinoDetectionList));
		result.calculateTotalsPerHour();
		return result;
	}

	@Override
	public List<GroupedArduinoDetectionDTO> findAllByRange(String day1, String day2) {
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
		List<ArduinoDetectionDTO> arduinoDetectionDTOList = ArduinoDetectionMapper.INSTANCE.toArduinoDetectionDTOList(result);
		//Crea una mappa con il fine di raggruppare tutte le occorrenze per giorno (infatti la chiave è il giorno)
		Map<LocalDate, List<ArduinoDetectionDTO>> groupedByDay = arduinoDetectionDTOList.stream()
				.collect(Collectors.groupingBy(detection -> detection.getDate().toLocalDate()));

		List<GroupedArduinoDetectionDTO> groupedArduinoDetectionDTO = new ArrayList<>();
		for (Map.Entry<LocalDate, List<ArduinoDetectionDTO>> entry : groupedByDay.entrySet()) {
			GroupedArduinoDetectionDTO groupedDto = new GroupedArduinoDetectionDTO();
			groupedDto.setDay(entry.getKey());
			groupedDto.setDetections(entry.getValue());
			groupedDto.calculateTotals();
			groupedArduinoDetectionDTO.add(groupedDto);
		}

		//ordinamento per data crescente
		Collections.sort(groupedArduinoDetectionDTO, new Comparator<GroupedArduinoDetectionDTO>() {
			@Override
			public int compare(GroupedArduinoDetectionDTO dto1, GroupedArduinoDetectionDTO dto2) {
				return dto1.getDay().compareTo(dto2.getDay());
			}
		});
		return groupedArduinoDetectionDTO;
	}

	@Override
	public ArduinoDetectionDTO create(ArduinoDetectionDTO dto) {
		ArduinoDetection entity = ArduinoDetectionMapper.INSTANCE.toArduinoDetectionEntity(dto);
		entity.setDate(LocalDateTime.now());
		repository.save(entity);
		return dto;
	}

}
