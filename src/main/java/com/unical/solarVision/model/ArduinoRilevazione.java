package com.unical.solarVision.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "ArduinoRilevazione")
public class ArduinoRilevazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private Long misurazioneInstantanea;
	@Column
	private Long produzioneGiornaliera;
	@Column
	private LocalDateTime ultimaMisurazione = LocalDateTime.now();

}
