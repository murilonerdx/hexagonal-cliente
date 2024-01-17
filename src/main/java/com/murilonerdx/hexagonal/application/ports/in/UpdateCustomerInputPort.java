package com.murilonerdx.hexagonal.application.ports.in;

import com.murilonerdx.hexagonal.application.core.domain.Customer;


public interface UpdateCustomerInputPort {
    void update(Customer customer, String zipCode);
}
