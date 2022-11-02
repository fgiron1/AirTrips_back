package com.airtrips.MsFlight.Repository;

import com.airtrips.MsFlight.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TicketInterface extends JpaRepository<UUID, Ticket> {

}
