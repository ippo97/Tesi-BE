package com.unical.solarVision.dto;

import com.unical.solarVision.model.DetectionType;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
    public class DailyArduinoDetectionDTO {
        private LocalDate day;
        private List<Long> totalPerHoursInput;
        private List<Long> totalPerHoursOutput;
        private Long totalInput;
        private Long totalOutput;
        private List<ArduinoDetectionDTO> detections;

        public void calculateTotalsPerHour() {
            totalPerHoursInput = new ArrayList<>();
            totalPerHoursOutput = new ArrayList<>();

            // Inizializza gli array dei totali per ogni ora
            for (int i = 0; i < 24; i++) {
                totalPerHoursInput.add(0L);
                totalPerHoursOutput.add(0L);
            }

            // Calcola i totali per ogni ora
            for (ArduinoDetectionDTO detectionDTO : detections) {
                if (detectionDTO.getDate().toLocalDate().equals(day)) {
                    int hour = detectionDTO.getDate().getHour();
                    long value = detectionDTO.getValue();
                    if (detectionDTO.getType() == DetectionType.INPUT) {
                        long currentTotal = totalPerHoursInput.get(hour);
                        totalPerHoursInput.set(hour, currentTotal + value);
                    } else {
                        long currentTotal = totalPerHoursOutput.get(hour);
                        totalPerHoursOutput.set(hour, currentTotal + value);
                    }
                }
            }

            // Calcola i totali complessivi
            totalInput = totalPerHoursInput.stream().mapToLong(Long::longValue).sum();
            totalOutput = totalPerHoursOutput.stream().mapToLong(Long::longValue).sum();
        }
    }