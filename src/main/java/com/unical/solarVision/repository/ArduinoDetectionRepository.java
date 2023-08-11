package com.unical.solarVision.repository;



import java.time.LocalDateTime;

import com.unical.solarVision.model.ArduinoDetection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;

@Repository
public interface ArduinoDetectionRepository extends JpaRepository<ArduinoDetection,Long> {

    @Query(value = "SELECT * FROM arduino_detection order by date desc limit 1", nativeQuery = true)
    ArduinoDetection lastDetection();
}
