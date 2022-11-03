package com.airtrips.MsFlight.Services;

import com.airtrips.MsFlight.Models.Flight;
import com.airtrips.MsFlight.Repository.FlightRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class FlightService {
    @Autowired
    FlightRepository repo;

    @Transactional
    public List<Flight> filterByAirline(String airline){
        // BUSINESS LOGIC GOES HERE
        return repo.filterByAirLine(airline).iterator().next();
    }

    @Transactional
    public List<Flight> filterByLayovers(int layoverNumber, UUID origin, UUID destination){
        // BUSINESS LOGIC GOES HERE
        return repo.filterByLayovers(layoverNumber, origin, destination).iterator().next();
    }

    @Transactional
    public List<Flight> filterByDateAndOrigin(Instant date, UUID origin, UUID destination){
        // BUSINESS LOGIC GOES HERE
        return repo.filterByDateAndOrigin(date, origin, destination).iterator().next();
    }

    @Transactional
    public Flight findFlightById(UUID id){
        return repo.findById(id).get();
    }
    @Transactional
    public List<Flight> findAllFlights(){
        return repo.findAll();
    }



}
