package com.airtrips.MsFlight.Controllers;

import com.airtrips.MsFlight.Models.Flight;
import com.airtrips.MsFlight.Services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/flight")
public class FlightController {

    @Autowired
    FlightService service;

    public FlightController(){}

    @GetMapping("/filter")
    public ResponseEntity<List<Flight>> filterByAirline(@RequestParam(required = false, value="airline") String airline,
                                                        @RequestParam(required = false, value="layout_number") String layout_number,
                                                        @RequestParam(required = false, value="origin") String origin,
                                                        @RequestParam(required = false, value="destination") String destination){
        List<Flight> list = null;
        HttpStatus status = null;
        try{
            list = service.filterByAirline(airline);
            status = HttpStatus.OK;
        } catch (NoSuchElementException e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(list, status);
    }

    /*@GetMapping("/filter")
    public ResponseEntity<List<Flight>> filterByAirline(@RequestParam(value="airline") String airline){
        List<Flight> list = null;
        HttpStatus status = null;
        try{
            list = service.filterByAirline(airline);
            status = HttpStatus.OK;
        } catch (NoSuchElementException e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(list, status);
    }*/

    @GetMapping("/{id}")
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

}
