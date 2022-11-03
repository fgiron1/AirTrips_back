package com.airtrips.MsFlight.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "flights")
public class Flight implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private UUID id;
    @Column(nullable = false)
    private String airLine;
    @Column(nullable = false)
    private Instant departureDate;
    @Column(nullable = false)
    private Instant arrivalDate;
    @Column(nullable = false)
    private Double distance;
    @Column(nullable = false)
    private Integer maxCapacity;
    @Column(nullable = false)
    private Integer actualCapacity;

    @OneToMany(mappedBy = "flightId", fetch = FetchType.LAZY)
    private List<Ticket> ticketList;

    @ManyToOne
    @JoinColumn(name = "origin_id", nullable = false)
    private Airport originId;

    @ManyToOne
    @JoinColumn(name = "destination_id", nullable = false)
    private Airport destinationId;

    @ManyToOne
    @JoinColumn(name = "layover_id", referencedColumnName = "id", nullable = true)
    private Flight layoverId;

    @OneToMany(mappedBy = "layoverId", fetch = FetchType.LAZY)
    private List<Flight> layoverList;

}
