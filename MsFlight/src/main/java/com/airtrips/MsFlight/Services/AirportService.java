package com.airtrips.MsFlight.Services;

import com.airtrips.MsFlight.Models.Airport;
import com.airtrips.MsFlight.Repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AirportService {
    @Autowired
    private AirportRepository repository;
    public List<Airport> getAllAirports() {
        return repository.findAll();
    }

    public List<Airport> getAllAirportsByCountry(String country) {
        return repository.filterByCountry(country).iterator().next();
    }

    public Airport getAirportById(UUID id) {
        return repository.findById(id).get();
    }


}
