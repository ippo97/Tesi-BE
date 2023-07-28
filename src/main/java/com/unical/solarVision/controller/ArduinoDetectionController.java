package com.unical.solarVision.controller;

import com.unical.solarVision.dto.ArduinoDetectionDTO;
import com.unical.solarVision.service.ArduinoDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("detection")
public class ArduinoDetectionController {
    @Autowired
    private ArduinoDetectionService arduinoDetectionService;
    @GetMapping("findAllByDay/{day}")
    public ResponseEntity<List<ArduinoDetectionDTO>> getAllByDay(@PathVariable String day) {
        return new ResponseEntity<List<ArduinoDetectionDTO>>(arduinoDetectionService.findAllByDay(day), HttpStatus.OK);

    }
    @GetMapping("findAllByRange/{day1}/{day2}")
    public ResponseEntity<List<ArduinoDetectionDTO>> getAllByRange(@PathVariable String day1, @PathVariable String day2) {
        return new ResponseEntity<List<ArduinoDetectionDTO>>(arduinoDetectionService.findAllByRange(day1, day2), HttpStatus.OK);

    }
    @PostMapping("/create")
    public ResponseEntity<ArduinoDetectionDTO> createArduinoDetection(@RequestBody ArduinoDetectionDTO dto) {
        ArduinoDetectionDTO createdDto = arduinoDetectionService.create(dto);
        return new ResponseEntity<>(createdDto, HttpStatus.CREATED);
    }

}
