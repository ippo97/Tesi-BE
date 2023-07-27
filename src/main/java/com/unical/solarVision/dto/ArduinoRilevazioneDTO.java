package com.unical.solarVision.dto;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ArduinoRilevazioneDTO {

	private Long misurazioneInstantanea;
	
	private Long produzioneGiornaliera;
	
	private LocalDateTime ultimaMisurazione = LocalDateTime.now();
}
