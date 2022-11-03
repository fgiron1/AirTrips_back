package com.airtrips.MsFlight.Controllers;

import com.airtrips.MsFlight.Models.Flight;
import com.airtrips.MsFlight.Services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlightController {

    @Autowired
    FlightService service;

    public FlightController(){}

    @GetMapping("/api/v1/flight/filter")
    public List<Flight> filterByAirline(@RequestParam(value="airline") String airline){
        return service.filterByAirline(airline);
    }

}
