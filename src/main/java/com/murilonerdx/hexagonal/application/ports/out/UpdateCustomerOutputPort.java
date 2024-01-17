package com.murilonerdx.hexagonal.application.ports.out;

import com.murilonerdx.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {
    void update(Customer customer);
}
