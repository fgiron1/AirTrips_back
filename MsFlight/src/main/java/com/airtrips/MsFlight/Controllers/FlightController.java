package com.airtrips.MsFlight.Controllers;

import com.airtrips.MsFlight.Models.Flight;
import com.airtrips.MsFlight.Services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/flight")
public class FlightController {

    @Autowired
    FlightService service;

    public FlightController(){}

    @GetMapping("/filter")
    public ResponseEntity<List<Flight>> filterByAirline(@RequestParam(value="airline") String airline){
        List<Flight> list = null;
        HttpStatus status = null;
        try{
            list = service.filterByAirline(airline);
        } catch (NoSuchElementException e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(list, status);
    }

}
