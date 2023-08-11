package com.unical.solarVision.model;

import lombok.*;

import javax.persistence.*;


import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "arduinoDetection")
public class ArduinoDetection {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String plantName;
	@Column
	private Long value;
	@Column
	private DetectionType type;
	@Column
	private LocalDateTime date;

}

