package com.airtrips.MsFlight;

import com.airtrips.MsFlight.Services.AirportService;
import com.airtrips.MsFlight.Models.Airport;
import com.airtrips.MsFlight.Services.AirportService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
public class AirportServiceTests {
    @Autowired
    private AirportService service;
    private static UUID VALID_ID = UUID.fromString("1ca1694a-debe-4d8e-a9c1-d32eccb3fde7");
    private static UUID INVALID_ID = UUID.fromString("00000000-0000-0000-0000-000000000000");
    private static Airport VALID_AIRPORT = new Airport(VALID_ID, "AmBisome", "China", "Ganxi", null, null);


    @Test
    void GetAllAirports_WorkAsExpected_WhenCalled() {
        List<Airport> airportList = service.getAllAirports();

        Assert.notEmpty(airportList, "Assert that the returned list is not empty");
    }

    @Test
    void GetAirport_ReturnsTheCorrectAirport_WhenUsingValidId() {
        Airport airport = service.getAirportById(VALID_ID);

        Assert.notNull(airport, "Assert that the returned airport is not null");
        Assert.isTrue(airport.getId().equals(VALID_AIRPORT.getId()), "Assert that the returned airport have the correct id");
        Assert.isTrue(airport.getName().equals(VALID_AIRPORT.getName()), "Assert that the returned airport have the correct name");
    }

    @Test
    void GetAirport_ReturnsNull_WhenUsingInvalidId() {
        try{
            Airport airport = service.getAirportById(INVALID_ID);
        } catch (NoSuchElementException e){
            return;
        }
        fail("An invalid ID returned a record");
    }

    @Test
    void GetAirportByCountry_ReturnsAllAirportsFromGivenCountry_WhenCalled() {
        List<Airport> airports = service.getAllAirportsByCountry("China");

        Assert.notEmpty(airports, "The returned list of airports is not empty when using existing country");
    }

    @Test
    @Transactional
    void GetAirportByCountry_ReturnsAnEmptyList_WhenUsingNonExistingCountry() {
        List<Airport> airports;
        try {
            airports = service.getAllAirportsByCountry("");
        } catch (NoSuchElementException e) {
            return;
        }
        if (airports.size() == 0){
            return;
        }
            fail("The returned list of airports is empty when using non existing country");
    }
}
