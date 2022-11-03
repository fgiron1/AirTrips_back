package com.airtrips.MsFlight.Models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.UUID;

@Entity
@Table(name = "tickets")
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private UUID id;
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

    public Ticket(UUID id, DecimalFormat price, boolean hasLuggage, Customer customerId, Flight flightId) {
        this.id = id;
        this.price = price;
        this.hasLuggage = hasLuggage;
        this.customerId = customerId;
        this.flightId = flightId;
    }

    public Ticket(DecimalFormat price, boolean hasLuggage, Customer customerId, Flight flightId) {
        this.price = price;
        this.hasLuggage = hasLuggage;
        this.customerId = customerId;
        this.flightId = flightId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public DecimalFormat getPrice() {
        return price;
    }

    public void setPrice(DecimalFormat price) {
        this.price = price;
    }

    public boolean isHasLuggage() {
        return hasLuggage;
    }

    public void setHasLuggage(boolean hasLuggage) {
        this.hasLuggage = hasLuggage;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Flight getFlightId() {
        return flightId;
    }

    public void setFlightId(Flight flightId) {
        this.flightId = flightId;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", price=" + price +
                ", hasLuggage=" + hasLuggage +
                ", customerId=" + customerId +
                ", flightId=" + flightId +
                '}';
    }
}
