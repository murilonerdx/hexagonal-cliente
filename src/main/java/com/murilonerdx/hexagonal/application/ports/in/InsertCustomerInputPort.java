package com.murilonerdx.hexagonal.application.ports.in;

import com.murilonerdx.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {
    void insert(Customer customer, String zipCode);
}
