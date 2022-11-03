package com.airtrips.MsFlight.Repository;

import com.airtrips.MsFlight.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, UUID> {

    @Query(value = "SELECT * FROM tickets WHERE hasLuggage=:hasLuggage", nativeQuery = true)
    Stream<Ticket> filterByLuggage(boolean hasLuggage);

    @Query(value = "SELECT * FROM tickets WHERE customerId=:customerId", nativeQuery = true)
    Stream<Ticket> filterByCustomerId(UUID customerId);

    @Query(value = "SELECT * FROM tickets WHERE flightId=:flightId", nativeQuery = true)
    Stream<Ticket> filterByFlightId(UUID flightId);

}
