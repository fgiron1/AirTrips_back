package com.airtrips.MsFlight;


import com.airtrips.MsFlight.Models.Flight;
import com.airtrips.MsFlight.Services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class FlightServiceTests {

    @Autowired
    private FlightService service;
    private static UUID VALID_ID = UUID.fromString("29a7d484-89ec-400c-a181-89b82ba1b0b2");
    private static UUID INVALID_ID = UUID.fromString("00000000-0000-0000-0000-000000000000");
    private static Flight VALID_FLIGHT = new Flight(VALID_ID, "Ryanair", "")
}
