package com.airtrips.MsFlight.Models;


import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "flights")
public class Flight implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "origin_id", nullable = false)
    private Airport originId;

    @ManyToOne
    @JoinColumn(name = "destination_id", nullable = false)
    private Airport destinationId;

    @ManyToOne
    @JoinColumn(name = "layover_id", referencedColumnName = "id", nullable = true)
    private Flight layoverId;
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


    @OneToMany(mappedBy = "layoverId", fetch = FetchType.LAZY)
    private List<Flight> layoverList;


    public Flight(UUID id, Airport originId, Airport destinationId, Flight layoverId, String airLine, Instant departureDate, Instant arrivalDate, Double distance, Integer maxCapacity, Integer actualCapacity, List<Ticket> ticketList, List<Flight> layoverList) {
        this.id = id;
        this.originId = originId;
        this.destinationId = destinationId;
        this.layoverId = layoverId;
        this.airLine = airLine;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.distance = distance;
        this.maxCapacity = maxCapacity;
        this.actualCapacity = actualCapacity;
        this.ticketList = ticketList;
        this.layoverList = layoverList;
    }

    public Flight(Airport originId, Airport destinationId, Flight layoverId, String airLine, Instant departureDate, Instant arrivalDate, Double distance, Integer maxCapacity, Integer actualCapacity, List<Ticket> ticketList, List<Flight> layoverList) {
        this.originId = originId;
        this.destinationId = destinationId;
        this.layoverId = layoverId;
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

    public Airport getOriginId() {
        return originId;
    }

    public void setOriginId(Airport originId) {
        this.originId = originId;
    }

    public Airport getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Airport destinationId) {
        this.destinationId = destinationId;
    }

    public Flight getLayoverId() {
        return layoverId;
    }

    public void setLayoverId(Flight layoverId) {
        this.layoverId = layoverId;
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
                ", originId=" + originId +
                ", destinationId=" + destinationId +
                ", layoverId=" + layoverId +
                ", layoverList=" + layoverList +
                '}';
    }
}
