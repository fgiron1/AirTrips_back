package com.airtrips.MsFlight.Repository;

import com.airtrips.MsFlight.Models.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface AirportRepository extends JpaRepository<Airport, UUID> {

    @Query(value = "SELECT * FROM airports WHERE country=:country", nativeQuery = true)
    List<Airport> filterByCountry(String country);


}
