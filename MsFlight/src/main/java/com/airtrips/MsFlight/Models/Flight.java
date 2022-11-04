package com.airtrips.MsFlight.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "flights")
public class Flight implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, columnDefinition = "uuid")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "origin_id", nullable = false)
    private Airport origin_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_id", nullable = false)
    private Airport destination_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "layover_id", referencedColumnName = "id", nullable = true)
    private Flight layover_id;
    @Column(name = "airline_name", nullable = false)
    private String airLine;
    @Column(name = "departure_date",nullable = false)
    private Instant departureDate;
    @Column(name = "arrival_date", nullable = false)
    private Instant arrivalDate;
    @Column(nullable = false)
    private Double distance;
    @Column(name = "max_capacity", nullable = false)
    private Integer maxCapacity;
    @Column(name="actual_capacity", nullable = false)
    private Integer actualCapacity;

    @OneToMany(mappedBy = "flight_id", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Ticket> ticketList;


    @OneToMany(mappedBy = "layover_id", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Flight> layoverList;

    public Flight(){}

    public Flight(UUID id, Airport origin_id, Airport destination_id, Flight layover_id, String airLine, Instant departureDate, Instant arrivalDate, Double distance, Integer maxCapacity, Integer actualCapacity, List<Ticket> ticketList, List<Flight> layoverList) {
        this.id = id;
        this.origin_id = origin_id;
        this.destination_id = destination_id;
        this.layover_id = layover_id;
        this.airLine = airLine;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.distance = distance;
        this.maxCapacity = maxCapacity;
        this.actualCapacity = actualCapacity;
        this.ticketList = ticketList;
        this.layoverList = layoverList;
    }

    public Flight(Airport origin_id, Airport destination_id, Flight layover_id, String airLine, Instant departureDate, Instant arrivalDate, Double distance, Integer maxCapacity, Integer actualCapacity, List<Ticket> ticketList, List<Flight> layoverList) {
        this.origin_id = origin_id;
        this.destination_id = destination_id;
        this.layover_id = layover_id;
        this.airLine = airLine;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.distance = distance;
        this.maxCapacity = maxCapacity;
        this.actualCapacity = actualCapacity;
        this.ticketList = ticketList;
        this.layoverList = layoverList;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAirLine() {
        return airLine;
    }

    public void setAirLine(String airLine) {
        this.airLine = airLine;
    }

    public Instant getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Instant departureDate) {
        this.departureDate = departureDate;
    }

    public Instant getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Instant arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Integer getActualCapacity() {
        return actualCapacity;
    }

    public void setActualCapacity(Integer actualCapacity) {
        this.actualCapacity = actualCapacity;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public Airport getOrigin_id() {
        return origin_id;
    }

    public void setOrigin_id(Airport origin_id) {
        this.origin_id = origin_id;
    }

    public Airport getDestination_id() {
        return destination_id;
    }

    public void setDestination_id(Airport destination_id) {
        this.destination_id = destination_id;
    }

    public Flight getLayover_id() {
        return layover_id;
    }

    public void setLayover_id(Flight layover_id) {
        this.layover_id = layover_id;
    }

    public List<Flight> getLayoverList() {
        return layoverList;
    }

    public void setLayoverList(List<Flight> layoverList) {
        this.layoverList = layoverList;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", airLine='" + airLine + '\'' +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", distance=" + distance +
                ", maxCapacity=" + maxCapacity +
                ", actualCapacity=" + actualCapacity +
                ", ticketList=" + ticketList +
                ", originId=" + origin_id +
                ", destinationId=" + destination_id +
                ", layoverId=" + layover_id +
                ", layoverList=" + layoverList +
                '}';
    }
}
