package com.airtrips.MsFlight.Controllers;

import com.airtrips.MsFlight.Models.Airport;
import com.airtrips.MsFlight.Models.Flight;
import com.airtrips.MsFlight.Services.AirportService;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/flight")
public class AirportController {

    @Autowired
    AirportService service;

    @GetMapping("/airport")
    @CrossOrigin
    public ResponseEntity<List<Airport>> getAllAirports(){
        List<Airport> airports = null;
        HttpStatus status = null;
        try{
            airports = service.getAllAirports();
            status = HttpStatus.OK;
        } catch (NoSuchElementException e) {
            status = HttpStatus.NO_CONTENT;
        }

        return new ResponseEntity<>(airports, status);
    }

    @GetMapping("/airport/{id}")
    @CrossOrigin
    public ResponseEntity<Airport> getAirportsById(@PathVariable String id){
        Airport a = null;
        HttpStatus status = null;
        try{
            a = service.getAirportById(UUID.fromString(id));
            status = HttpStatus.OK;
        } catch (NoSuchElementException e) {
            status = HttpStatus.NO_CONTENT;
        }

        return new ResponseEntity<>(a, status);
    }
}
