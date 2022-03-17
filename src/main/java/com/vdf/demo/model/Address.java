package com.vdf.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "seq_address"
    )
    @SequenceGenerator(
        name = "seq_address"
    )
    private long id;

    private String city;

    private String country;

    private String street;

    @OneToOne
    @JoinColumn(name = "employee_id")
    @MapsId
    private Employee employee;

}
