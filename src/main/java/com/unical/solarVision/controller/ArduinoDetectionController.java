package com.unical.solarVision.controller;

import com.unical.solarVision.dto.ArduinoDetectionDTO;
import com.unical.solarVision.dto.DailyArduinoDetectionDTO;
import com.unical.solarVision.dto.GroupedArduinoDetectionDTO;
import com.unical.solarVision.service.ArduinoDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("detection")
public class ArduinoDetectionController {
    @Autowired
    private ArduinoDetectionService arduinoDetectionService;
    @GetMapping("findAllByDay/{day}")
    public ResponseEntity<DailyArduinoDetectionDTO> getAllByDay(@PathVariable String day) {
        return new ResponseEntity<DailyArduinoDetectionDTO>(arduinoDetectionService.findAllByDay(day), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ArduinoDetectionDTO> createArduinoDetection(@RequestBody ArduinoDetectionDTO dto) {
        ArduinoDetectionDTO createdDto = arduinoDetectionService.create(dto);
        return new ResponseEntity<>(createdDto, HttpStatus.CREATED);
    }

    @GetMapping("findAllByRange/{start}/{end}")
    public ResponseEntity<List<GroupedArduinoDetectionDTO>> getAllByRange(@PathVariable String start, @PathVariable String end) {

        List<GroupedArduinoDetectionDTO> allDetections = arduinoDetectionService.findAllByRange(start, end);

        return new ResponseEntity<>(allDetections, HttpStatus.OK);
    }
}
