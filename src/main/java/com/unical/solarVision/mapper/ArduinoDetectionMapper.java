package com.unical.solarVision.mapper;

import com.unical.solarVision.dto.ArduinoDetectionDTO;
import com.unical.solarVision.model.ArduinoDetection;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ArduinoDetectionMapper {
	public static ArduinoDetectionMapper INSTANCE = Mappers.getMapper(ArduinoDetectionMapper.class);
	ArduinoDetectionDTO toArduinoDetectionDTO(ArduinoDetection arduinoDetection);
	ArduinoDetection toArduinoDetectionEntity(ArduinoDetectionDTO dto);
	List<ArduinoDetectionDTO> toArduinoDetectionDTOList(List<ArduinoDetection> list);
	List<ArduinoDetection> toArduinoDetectionList(List<ArduinoDetectionDTO> list);
}
