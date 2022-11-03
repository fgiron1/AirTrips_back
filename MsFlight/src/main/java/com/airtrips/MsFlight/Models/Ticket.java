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
    @Column(name="has_luggage", nullable = false)
    private boolean hasLuggage;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight_id;

    public Ticket(){}
    public Ticket(UUID id, DecimalFormat price, boolean hasLuggage, Customer customerId, Flight flight_id) {
        this.id = id;
        this.price = price;
        this.hasLuggage = hasLuggage;
        this.customerId = customerId;
        this.flight_id = flight_id;
    }

    public Ticket(DecimalFormat price, boolean hasLuggage, Customer customerId, Flight flight_id) {
        this.price = price;
        this.hasLuggage = hasLuggage;
        this.customerId = customerId;
        this.flight_id = flight_id;
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

    public Flight getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(Flight flight_id) {
        this.flight_id = flight_id;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", price=" + price +
                ", hasLuggage=" + hasLuggage +
                ", customerId=" + customerId +
                ", flightId=" + flight_id +
                '}';
    }
}
