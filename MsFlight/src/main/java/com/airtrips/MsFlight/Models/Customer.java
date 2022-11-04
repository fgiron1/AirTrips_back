package com.airtrips.MsFlight.Models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Customers")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    @JsonIgnore
    private UUID id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "last_name", nullable = false)
    private String last_name;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    private String nationality;
    @Column(nullable = false)
    private String id_number;

    @OneToMany(mappedBy = "customerId", fetch = FetchType.LAZY)
    private List<Ticket> ticketList;

    public Customer(){}
    public Customer(UUID id, String name, String last_name, Integer age, String nationality, String id_number, List<Ticket> ticketList) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.age = age;
        this.nationality = nationality;
        this.id_number = id_number;
        this.ticketList = ticketList;
    }

    public Customer(String name, String last_name, Integer age, String nationality, String id_number, List<Ticket> ticketList) {
        this.name = name;
        this.last_name = last_name;
        this.age = age;
        this.nationality = nationality;
        this.id_number = id_number;
        this.ticketList = ticketList;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
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
                ", first_name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age=" + age +
                ", nacionality='" + nationality + '\'' +
                ", id_number='" + id_number + '\'' +
                ", ticketList=" + ticketList +
                '}';
    }
}
