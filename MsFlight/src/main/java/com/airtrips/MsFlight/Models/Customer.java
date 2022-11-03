package com.airtrips.MsFlight.Models;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "customers")
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

    @OneToMany(mappedBy = "customerId", fetch = FetchType.LAZY)
    private List<Ticket> ticketList;

    public Customer(UUID id, String first_name, String last_name, Integer age, String nacionality, String id_number, List<Ticket> ticketList) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.nacionality = nacionality;
        this.id_number = id_number;
        this.ticketList = ticketList;
    }

    public Customer(String first_name, String last_name, Integer age, String nacionality, String id_number, List<Ticket> ticketList) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.nacionality = nacionality;
        this.id_number = id_number;
        this.ticketList = ticketList;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNacionality() {
        return nacionality;
    }

    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age=" + age +
                ", nacionality='" + nacionality + '\'' +
                ", id_number='" + id_number + '\'' +
                ", ticketList=" + ticketList +
                '}';
    }
}
