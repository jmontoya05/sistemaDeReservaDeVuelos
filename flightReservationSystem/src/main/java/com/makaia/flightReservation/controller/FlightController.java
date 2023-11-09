package com.makaia.flightReservation.controller;

import com.makaia.flightReservation.dto.FlightRequestDTO;
import com.makaia.flightReservation.dto.FlightResponseDTO;
import com.makaia.flightReservation.model.Flight;
import com.makaia.flightReservation.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {
    private final FlightService flightService;
    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping
    public ResponseEntity<FlightRequestDTO> saveFlight(@RequestBody FlightRequestDTO flightRequestDTO){
        return new ResponseEntity<>(flightService.saveFlight(flightRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{flightCode}")
    public ResponseEntity<FlightResponseDTO> getFlight(@PathVariable String flightCode){
        return new ResponseEntity<>(flightService.getFlight(flightCode), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<FlightResponseDTO>> getFlights(){
        return new ResponseEntity<>(flightService.getFlights(), HttpStatus.OK);
    }

    /*@PutMapping("/{flightCode}")
    public ResponseEntity<Flight> updateFlight(@RequestBody Flight flight, @PathVariable String flightCode){
        return new ResponseEntity<>(flightService.updateFlight(flight, flightCode), HttpStatus.CREATED);
    }

    @DeleteMapping("/{flightCode}")
    public ResponseEntity<String> deleteFlight(@PathVariable String flightCode){
        return new ResponseEntity<>(flightService.deleteFlight(flightCode), HttpStatus.NO_CONTENT);
    }*/
}
