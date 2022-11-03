package com.airtrips.MsFlight.Repository;

import com.airtrips.MsFlight.models.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface AirportRepository extends JpaRepository<Airport, UUID> {

    @Query(value = "SELECT * FROM airport WHERE origin=:origin", nativeQuery = true)
    Stream<Airport> filterByCountry(String origin);


}
