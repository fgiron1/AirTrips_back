package com.airtrips.MsFlight.Repository;

import com.airtrips.MsFlight.models.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AirportInterface extends JpaRepository<UUID, Airport> {
    List<Airport> findByCountryName(String country);
}
