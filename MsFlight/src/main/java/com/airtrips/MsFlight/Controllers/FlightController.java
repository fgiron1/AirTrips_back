package com.airtrips.MsFlight.Controllers;

import com.airtrips.MsFlight.Models.Flight;
import com.airtrips.MsFlight.Services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/flight")
public class FlightController {

    @Autowired
    FlightService service;

    public FlightController(){}

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Flight> getFlightById(@PathVariable String id){
        Flight f = null;
        HttpStatus status = null;
        try{
            f = service.findFlightById(UUID.fromString(id));
            status = HttpStatus.OK;
        } catch (NoSuchElementException e) {
            status = HttpStatus.NO_CONTENT;
        }

        return new ResponseEntity<>(f, status);
    }

    @GetMapping("/")
    @CrossOrigin
    public ResponseEntity<List<Flight>> getAllFlights(){
        List<Flight> flights = null;
        HttpStatus status = null;
        try{
            flights = service.findAllFlights();
            status = HttpStatus.OK;
        } catch (NoSuchElementException e) {
            status = HttpStatus.NO_CONTENT;
        }

        return new ResponseEntity<>(flights, status);
    }

    @GetMapping("/get")
    @CrossOrigin
    public ResponseEntity<List<Flight>> getFlightsByAirportsAndTimestamp(@RequestParam(value = "departureDate") String departureDate,
                                                                         @RequestParam(value = "origin") String origin,
                                                                         @RequestParam(value= "destination") String destination){
        HttpStatus status = null;
        List<Flight> flights = null;
        // Casting query parameters to their corresponding types
        Instant departureDateFinal = Instant.parse(departureDate);
        UUID originFinal = UUID.fromString(origin);
        UUID destinationFinal = UUID.fromString(destination);

        try{
            flights = service.filterByDateAndOrigin(departureDateFinal, originFinal, destinationFinal);
            status = HttpStatus.OK;
        } catch (Exception e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<>(null, status);
        }

        return new ResponseEntity<>(flights, status);
    }

}
