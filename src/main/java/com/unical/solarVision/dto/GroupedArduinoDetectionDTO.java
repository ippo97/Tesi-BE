package com.unical.solarVision.dto;

import com.unical.solarVision.dto.ArduinoDetectionDTO;
import com.unical.solarVision.model.DetectionType;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupedArduinoDetectionDTO {
    private LocalDate day;
    private List<ArduinoDetectionDTO> detections;
    private Long totalInput;
    private Long totalOutput;

    public void calculateTotals() {
        totalInput = detections.stream()
                .filter(d -> d.getType() == DetectionType.INPUT)
                .mapToLong(ArduinoDetectionDTO::getValue)
                .sum();

        totalOutput = detections.stream()
                .filter(d -> d.getType() == DetectionType.OUTPUT)
                .mapToLong(ArduinoDetectionDTO::getValue)
                .sum();
    }
}