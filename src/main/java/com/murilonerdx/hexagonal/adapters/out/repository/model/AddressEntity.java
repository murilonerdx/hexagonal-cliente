package com.murilonerdx.hexagonal.adapters.out.repository.model;

import lombok.Data;

@Data
public class AddressEntity {
    private String street;
    private String city;
    private String state;
}
