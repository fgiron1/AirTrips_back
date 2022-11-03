package com.airtrips.MsFlight.Repository;

import com.airtrips.MsFlight.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query(value ="SELECT * FROM flights WHERE departureDate=:firstFlightDepartureDate", nativeQuery = true)
    Stream<Flight> getFligths(Instant firstFlightDepartureDate);

    @Query(nativeQuery = true, value = "SELECT * FROM find_flights_by_date(:desired_date, :origin, :destination)")
    String getFlightsByDate(@Param("desired_date") Instant desired_date,
                            @Param("origin") UUID origin, @Param("destination") UUID destination );
}
