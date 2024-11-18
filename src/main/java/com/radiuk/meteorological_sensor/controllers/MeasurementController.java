package com.radiuk.meteorological_sensor.controllers;

import com.radiuk.meteorological_sensor.dto.MeasurementDTO;
import com.radiuk.meteorological_sensor.dto.SensorDTO;
import com.radiuk.meteorological_sensor.models.Measurement;
import com.radiuk.meteorological_sensor.models.Sensor;
import com.radiuk.meteorological_sensor.services.MeasurementService;
import com.radiuk.meteorological_sensor.services.SensorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {

    private final MeasurementService measurementService;
    private final MeasurementDTO measurementDTO;
    private final ModelMapper modelMapper;

    @Autowired
    public MeasurementController(MeasurementService measurementService, MeasurementDTO measurementDTO, ModelMapper modelMapper) {
        this.measurementService = measurementService;
        this.measurementDTO = measurementDTO;
        this.modelMapper = modelMapper;
    }


    @GetMapping("")
    public List<MeasurementDTO> getSensors() {
        return measurementService.findAll().stream().map(this::convertToMeasurementDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MeasurementDTO getSensor(@PathVariable("id") int id) {
        return convertToMeasurementDTO(measurementService.findOne(id)); // Jackson конвектирует объект в JSON
    }


    @PostMapping("/add")
    public ResponseEntity<HttpStatus> createMeasurement(@RequestBody MeasurementDTO measurementDTO) {
        Measurement measurement = modelMapper.map(measurementDTO, Measurement.class);
        measurementService.save(measurement);
        return ResponseEntity.ok(HttpStatus.OK);
    }




    private Measurement convertToMeasurement(MeasurementDTO measurementDTO) {
        return modelMapper.map(measurementDTO, Measurement.class);
    }

    private MeasurementDTO convertToMeasurementDTO(Measurement measurement) {
        return modelMapper.map(measurement, MeasurementDTO.class);
    }
}
