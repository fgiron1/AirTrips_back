package com.airtrips.MsFlight.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.UUID;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Tickets")
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private UUID id;
//    @Column(nullable = false)
//    private UUID customerId;
//    @Column(nullable = false)
//    private UUID flightId;
    @Column(nullable = false)
    private DecimalFormat price;
    @Column(nullable = false)
    private boolean hasLuggage;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flightId;

}
