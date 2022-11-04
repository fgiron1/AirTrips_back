package com.airtrips.MsFlight.Repository;

import com.airtrips.MsFlight.Models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface FlightRepository extends JpaRepository<Flight, UUID> {
    @Query(value="SELECT * FROM Flights WHERE airline_name=:airline", nativeQuery = true)
    List<Flight> filterByAirLine(@Param("airline") String airline);

    @Query(value ="SELECT * FROM find_flights_by_layover(:layover_number, :origin, :destination)", nativeQuery = true)
    Stream<List<Flight>> filterByLayovers(@Param("layover_number") int layoverNumber,
                                          @Param("origin") UUID origin,
                                          @Param("destination") UUID destination);

    @Query(value ="SELECT * FROM find_flights_by_date(?1, ?2, ?3)", nativeQuery = true)
    Stream<List<Flight>> filterByDateAndOrigin(Instant flightDepartureDate, UUID origin, UUID destination);
}
