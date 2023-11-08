package com.makaia.flightReservation.controller;

import com.makaia.flightReservation.model.Airport;
import com.makaia.flightReservation.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airports")
public class AirportController {
    private final AirportService airportService;
    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @PostMapping
    public ResponseEntity<Airport> saveAirport(@RequestBody Airport airport){
        return new ResponseEntity<>(airportService.saveAirport(airport), HttpStatus.CREATED);
    }
    @GetMapping("/{airportId}")
    public ResponseEntity<Optional<Airport>> getAirport(@PathVariable Integer airportId){
        return new ResponseEntity<>(airportService.getAirport(airportId), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Airport>> getAirports(){
        return new ResponseEntity<>(airportService.getAirports(), HttpStatus.OK);
    }

    @PutMapping("/{airportId}")
    public ResponseEntity<Airport> updateAirport(@RequestBody Airport airport, @PathVariable Integer airportId){
        return new ResponseEntity<>(airportService.updateAirport(airport, airportId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{airportId}")
    public ResponseEntity<String> deleteAirport(@PathVariable Integer airportId){
        return new ResponseEntity<>(airportService.deleteAirport(airportId), HttpStatus.NO_CONTENT);
    }
}