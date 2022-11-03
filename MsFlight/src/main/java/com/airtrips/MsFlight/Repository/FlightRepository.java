package com.airtrips.MsFlight.Repository;

import com.airtrips.MsFlight.Models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface FlightRepository extends JpaRepository<Flight, UUID> {

    @Query(value="SELECT * FROM flights WHERE airline=:airline", nativeQuery = true)
    Stream<List<Flight>> filterByAirLine(String airline);

    @Query(value ="SELECT * FROM find_flights_by_layover(:layoverNumber, :origin, :destination)", nativeQuery = true)
    Stream<List<Flight>> filterByLayovers(int layoverNumber, UUID origin, UUID destination);

    @Query(value ="SELECT * FROM find_flights_by_date(:flightDepartureDate, :origin, :destination)", nativeQuery = true)
    Stream<List<Flight>> filterByDateAndOrigin(Instant flightDepartureDate, UUID origin, UUID destination);
}
