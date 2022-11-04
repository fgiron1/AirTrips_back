package com.airtrips.MsFlight.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "airports")
public class Airport implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, columnDefinition = "uuid")
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String city;

    @OneToMany(mappedBy = "origin_id", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Flight> originList;

    @OneToMany(mappedBy = "destination_id", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Flight> destinationList;

    public Airport(){}
    public Airport(UUID id, String name, String country, String city, List<Flight> originList, List<Flight> destinationList) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.originList = originList;
        this.destinationList = destinationList;
    }

    public Airport(String name, String country, String city, List<Flight> originList, List<Flight> destinationList) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.originList = originList;
        this.destinationList = destinationList;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Flight> getOriginList() {
        return originList;
    }

    public void setOriginList(List<Flight> originList) {
        this.originList = originList;
    }

    public List<Flight> getDestinationList() {
        return destinationList;
    }

    public void setDestinationList(List<Flight> destinationList) {
        this.destinationList = destinationList;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", originList=" + originList +
                ", destinationList=" + destinationList +
                '}';
    }
}
