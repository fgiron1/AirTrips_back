package com.airtrips.MsFlight.Repository;

import com.airtrips.MsFlight.Models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface FlightRepository extends JpaRepository<Flight, UUID> {

    @Query(value="SELECT * FROM flights WHERE airline=:airline", nativeQuery = true)
    Stream<Flight> filterByAirLine(String airline);

    @Query(value ="SELECT * FROM flights WHERE layover=:layoverNumber", nativeQuery = true)
    Stream<Flight> filterByScales(int layoverNumber);

    @Query(value ="SELECT * FROM flights WHERE departureDate=:flightDepartureDate", nativeQuery = true)
    Stream<Flight> filterByDepartureDates(Instant flightDepartureDate);
}
