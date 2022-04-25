package com.ctd.clinic.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Addresses")
@Getter @Setter
public class Address {

    @Id
    @SequenceGenerator(name = "address_sequence", sequenceName = "address_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence")
    private Long id;

    private String street;
    private int number;
    private String district;
    private String province;
}
