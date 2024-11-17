package com.radiuk.meteorological_sensor.repositories;

import com.radiuk.meteorological_sensor.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {

}
