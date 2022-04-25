package com.ctd.clinic.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AddressDTO {

    private Long id;
    private String street;
    private int number;
    private String district;
    private String province;
}
