package com.unical.solarVision.repository;



import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;
import com.unical.solarVision.model.ArduinoRilevazione;

@Repository
public interface ArduinoRilevazioneRepository extends JpaRepository<ArduinoRilevazione,Long> {

	Optional<ArduinoRilevazione> findByultimaMisurazione(LocalDateTime p);

}
