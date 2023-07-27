package com.unical.solarVision.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.unical.solarVision.dto.ArduinoRilevazioneDTO;
import com.unical.solarVision.model.ArduinoRilevazione;

import java.util.List;

@Mapper
public interface ArduinoRilevazioneMapper {
	public static ArduinoRilevazioneMapper INSTANCE = Mappers.getMapper(ArduinoRilevazioneMapper.class);

	ArduinoRilevazioneDTO toArduinoRilevazioneDTO(ArduinoRilevazione arduinoRilevazione);
	List<ArduinoRilevazioneDTO> toArduinoRilevazioneDTOList(List<ArduinoRilevazione> list);
	
}
