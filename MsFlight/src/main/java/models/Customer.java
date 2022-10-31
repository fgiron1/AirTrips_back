package models;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Customers")

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column
    private String last_name;
    @Column
    private Integer age;
    @Column
    private String nacionality;
    @Column
    private String id_number;
}
