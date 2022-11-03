package com.airtrips.MsFlight.Services;

import com.airtrips.MsFlight.Models.Airport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AirportService {
    private AirportService repository;
    public List<Airport> getAllAirports() {
        return repository.getAllAirports();
    }

    public List<Airport> getAllAirportsByCountry(String country) {
        return repository.getAllAirportsByCountry(country);
    }

    public Airport getAirport(UUID id) {
        return repository.getAirport(id);
    }


}
