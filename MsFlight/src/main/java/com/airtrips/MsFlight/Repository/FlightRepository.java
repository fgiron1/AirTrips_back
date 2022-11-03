package com.airtrips.MsFlight.Repository;

import com.airtrips.MsFlight.models.Flight;
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

    @Query(value ="SELECT * FROM flights WHERE layover=:layover", nativeQuery = true)
    Stream<Flight> filterByScales(int layoverNumber);

    @Query(value ="SELECT * FROM flights WHERE departureDate=:departureDate", nativeQuery = true)
    Stream<Flight> getFligths(Instant firstFlightDepartureDate);
}
