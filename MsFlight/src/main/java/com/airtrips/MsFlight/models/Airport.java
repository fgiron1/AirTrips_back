package com.airtrips.MsFlight.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Airport implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String city;

    @OneToMany(mappedBy = "airport", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Flight> originList;

    @OneToMany(mappedBy = "airport", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Flight> destinationList;

}
