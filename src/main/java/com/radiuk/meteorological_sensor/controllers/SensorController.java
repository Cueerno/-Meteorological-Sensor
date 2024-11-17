package com.radiuk.meteorological_sensor.controllers;

import com.radiuk.meteorological_sensor.dto.SensorDTO;
import com.radiuk.meteorological_sensor.models.Sensor;
import com.radiuk.meteorological_sensor.services.SensorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    private final SensorService sensorService;
    private final SensorDTO sensorDTO;
    private final ModelMapper modelMapper;

    @Autowired
    public SensorController(SensorService sensorService, SensorDTO sensorDTO, ModelMapper modelMapper) {
        this.sensorService = sensorService;
        this.sensorDTO = sensorDTO;
        this.modelMapper = modelMapper;
    }


    @GetMapping("")
    public List<SensorDTO> getSensors() {
        return sensorService.findAll().stream().map(this::convertToSensorDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public SensorDTO getSensor(@PathVariable("id") int id) {
        return convertToSensorDTO(sensorService.findOne(id)); // Jackson конвектирует объект в JSON
    }


    @PostMapping("")
    public ResponseEntity<HttpStatus> createSensor(@RequestBody SensorDTO sensorDTO) {
        sensorService.save(convertToSensor(sensorDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @GetMapping("/name")
    public SensorDTO getSensorByName(@RequestParam("name") String name) {
        return convertToSensorDTO(sensorService.findByName(name).get());
    }





    private Sensor convertToSensor(SensorDTO sensorDTO) {
        return modelMapper.map(sensorDTO, Sensor.class);
    }

    private SensorDTO convertToSensorDTO(Sensor sensor) {
        return modelMapper.map(sensor, SensorDTO.class);
    }
}
