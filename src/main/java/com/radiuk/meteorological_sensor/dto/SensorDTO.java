package com.radiuk.meteorological_sensor.dto;

import org.springframework.stereotype.Component;

@Component
public class SensorDTO {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
