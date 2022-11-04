package com.airtrips.MsFlight;


import com.airtrips.MsFlight.Models.Airport;
import com.airtrips.MsFlight.Models.Flight;
import com.airtrips.MsFlight.Services.FlightService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
public class FlightServiceTests {

    @Autowired
    private FlightService service;
    private static UUID INVALID_ID = UUID.fromString("00000000-0000-0000-0000-000000000000");


    private static UUID ID_WITH_ONE_LAYOVER = UUID.fromString("ebee5ba4-7d8d-464a-bb4c-2a92dbffcd40");
    private static UUID ORIGIN_ONE_LAYOVER = UUID.fromString("8ecd3a95-d065-4ddc-88d8-129ff49e2172");
    private static UUID DESTINATION_ONE_LAYOVER = UUID.fromString("cd7ff342-18a5-4d9b-bb82-b6060436fc18");

    private static UUID ID_WITH_TWO_LAYOVERS = UUID.fromString("fa5f65d9-8342-4373-920f-f1719a1355ea");
    private static UUID ORIGIN_TWO_LAYOVERS = UUID.fromString("99a5ef8c-4ce7-411f-8ad9-bfd6a1b96d7d");
    private static UUID DESTINATION_TWO_LAYOVERS = UUID.fromString("64c5deb4-3a80-4a9f-a176-c2f296612ce6");
    //This flight involves VALID_TRIP_ORIGIN and VALID_TRIP_DESTINATION airports
    private static UUID VALID_TRIP_FLIGHT = UUID.fromString("71dc6ead-b590-45b1-aa00-c0cd88879b79");
    private static UUID VALID_TRIP_ORIGIN = UUID.fromString("97866abe-667f-4b43-99bf-b7fc264a468b");
    private static UUID VALID_TRIP_DESTINATION = UUID.fromString("2df0b812-a93e-4b39-bf48-d2db9b39441b");


    @Test
    public void readFlightById(){
        Assert.isTrue(ID_WITH_ONE_LAYOVER.equals(
                service.findFlightById(ID_WITH_ONE_LAYOVER).getId()),
                "Could not find a matching flight record with the same id.");
    }
    @Test
    public void filterByNonExistentAirline(){
        List<Flight> flights = service.filterByAirline("Invalid Airlines");
        Assert.isTrue(flights.isEmpty(), "A flight was returned when it should not.");
    }
    @Test
    public void filterByExistingAirline(){
        List<Flight> flights = service.filterByAirline("Aliquam PC");
        Assert.isTrue(!flights.isEmpty(), "A flight could not be found with matching airline name.");
    }
    @Test
    public void filterByOneLayoverValidAirports(){
        List<Flight> flights =  service.filterByLayovers(1, ORIGIN_ONE_LAYOVER, DESTINATION_ONE_LAYOVER);
        Flight possibleFlight = null;
        try{
            possibleFlight = service.findFlightById(ID_WITH_ONE_LAYOVER);
        } catch (Exception e) {
            fail("Specified flight does not even exist!");
        }
        List<UUID> flights_id = new ArrayList<UUID>();

        for(Flight f : flights){
            flights_id.add(f.getId());
        }
        Assert.isTrue(flights_id.contains(possibleFlight.getId()), "Specified flight does not have two layovers!");
    }
    @Test
    public void filterByTwoLayoverValidAirports(){
        List<Flight> flights =  service.filterByLayovers(2, ORIGIN_TWO_LAYOVERS, DESTINATION_TWO_LAYOVERS);
        Flight possibleFlight = null;
        try{
            possibleFlight = service.findFlightById(ID_WITH_TWO_LAYOVERS);
        } catch (Exception e) {
            fail("Specified flight does not even exist!");
        }
        List<UUID> flights_id = new ArrayList<UUID>();

        for(Flight f : flights){
            flights_id.add(f.getId());
        }
        Assert.isTrue(flights_id.contains(possibleFlight.getId()), "Specified flight does not have two layovers!");

    }
    @Test
    public void filterByPastDepartureDate(){
        List<Flight> flights =  service.filterByDateAndOrigin(Instant.now().minus(500, ChronoUnit.DAYS), VALID_TRIP_ORIGIN, VALID_TRIP_DESTINATION);
        boolean invalid = false;

        for(Flight f : flights){
            if(f.getDepartureDate().isAfter(Instant.now())){
                invalid = true;
                break;
            };
        }
        if(invalid){
            fail("There was at least one flight with future departure date.");
        } else {
            return;
        }
    }
    @Test
    public void filterByPresentDepartureDate(){
        List<Flight> flights =  service.filterByDateAndOrigin(Instant.now(), VALID_TRIP_ORIGIN, VALID_TRIP_DESTINATION);
        boolean invalid = false;

        for(Flight f : flights){
            if(f.getDepartureDate().equals(Instant.now())){
                invalid = true;
                break;
            };
        }
        if(invalid){
            fail("There was at least one flight with future departure date.");
        } else {
            return;
        }
    }
    @Test
    public void filterByFutureDepartureDate(){
        List<Flight> flights =  service.filterByDateAndOrigin(Instant.now().plus(500, ChronoUnit.DAYS), VALID_TRIP_ORIGIN, VALID_TRIP_DESTINATION);
        boolean invalid = false;

        for(Flight f : flights){
            if(f.getDepartureDate().isBefore(Instant.now())){
                invalid = true;
                break;
            };
        }
        if(invalid){
            fail("There was at least one flight with past departure date.");
        } else {
            return;
        }
    }
}
