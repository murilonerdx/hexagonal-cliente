package com.murilonerdx.hexagonal.application.ports.out;

import com.murilonerdx.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {
    Optional<Customer> find(String id);
}
