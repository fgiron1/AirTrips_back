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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Flight")
public class Flight implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private UUID id;

//    @Column(nullable = false)
//    private UUID originId;
//    @Column(nullable = false)
//    private UUID destinationId;
    @Column(nullable = false)
    private UUID layoverId;
    @Column(nullable = false)
    private String airLine;
    @Column(nullable = false)
    private Instant departureDate;
    @Column(nullable = false)
    private Double distance;
    @Column(nullable = false)
    private Integer max_capacity;
    @Column(nullable = false)
    private Integer actual_capacity;

    @OneToMany(mappedBy = "Flight", fetch = FetchType.LAZY)
    private List<Ticket> ticketList;

    @ManyToOne
    @JoinColumn(name = "origin_id", nullable = false)
    private Airport origin;

    @ManyToOne
    @JoinColumn(name = "destination_id", nullable = false)
    private Airport destination;


}
