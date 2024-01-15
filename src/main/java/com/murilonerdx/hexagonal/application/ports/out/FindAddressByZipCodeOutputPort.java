package com.murilonerdx.hexagonal.application.ports.out;

import com.murilonerdx.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {
    Address find(String zipCode);
}
