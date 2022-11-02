package com.airtrips.MsFlight.Repository;

import com.airtrips.MsFlight.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FlightInterface extends JpaRepository<UUID, Flight> {
}
