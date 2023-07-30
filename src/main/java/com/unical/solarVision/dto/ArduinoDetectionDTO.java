package com.unical.solarVision.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;


import com.unical.solarVision.model.DetectionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ArduinoDetectionDTO {
	private String plantName;
	private Long value;
	private DetectionType type;
	private LocalDateTime date;
}
