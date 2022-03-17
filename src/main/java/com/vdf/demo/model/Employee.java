package com.vdf.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String lastName;

    private String firstName;

    private LocalDate birthDate;

    private BigDecimal salary;

    private transient String role;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Account> accounts;

}
