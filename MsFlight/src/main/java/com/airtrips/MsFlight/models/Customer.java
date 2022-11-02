package com.airtrips.MsFlight.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Customers")

public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private UUID id;
    @Column(nullable = false)
    private String first_name;
    @Column(nullable = false)
    private String last_name;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    private String nacionality;
    @Column(nullable = false)
    private String id_number;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Ticket> ticketList = new ArrayList<>();

}
