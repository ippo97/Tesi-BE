package com.unical.solarVision.dto;

import com.unical.solarVision.model.DetectionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ArduinoDetectionRawData {
	private String plantName;
	private Long value;
	private DetectionType type;
}
