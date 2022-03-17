package com.vdf.demo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
//    @MapsId
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Employee employee;

}
