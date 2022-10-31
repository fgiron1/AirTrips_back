package models;


import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "Flights")

public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "originId")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "originId", referencedColumnName = "id")
    private UUID originId;
    @Column
    private UUID destinationId;
    @Column
    private UUID layoverId;
    @Column
    private String airLine;
    @Column
    private Instant departureDate;
    @Column
    private Double distance;
}
