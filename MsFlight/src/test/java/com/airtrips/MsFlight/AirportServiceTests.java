package com.airtrips.MsFlight;

import com.airtrips.MsFlight.Services.AirportService;
import com.airtrips.MsFlight.Models.Airport;
import com.airtrips.MsFlight.Services.AirportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;
import java.util.UUID;

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
        Airport airport = service.getAirport(VALID_ID);

        Assert.notNull(airport, "Assert that the returned airport is not null");
        Assert.isTrue(airport.getId().equals(VALID_AIRPORT.getId()), "Assert that the returned airport have the correct id");
        Assert.isTrue(airport.getName().equals(VALID_AIRPORT.getName()), "Assert that the returned airport have the correct name");
    }

    @Test
    void GetAirport_ReturnsNull_WhenUsingInvalidId() {
        Airport airport = service.getAirport(INVALID_ID);

        Assert.isNull(airport, "The returned airport is null");
    }

    @Test
    void GetAirportByCountry_ReturnsAllAirportsFromGivenCountry_WhenCalled() {
        List<Airport> airports = service.getAllAirportsByCountry("China");

        Assert.notEmpty(airports, "The returned list of airports is not empty when using existing country");
    }

    @Test
    void GetAirportByCountry_ReturnsAnEmptyList_WhenUsingNonExistingCountry() {
        List<Airport> airports = service.getAllAirportsByCountry("");

        Assert.isTrue(airports.size() == 0, "The returned list of airports is empty when using non existing country");
    }
}
