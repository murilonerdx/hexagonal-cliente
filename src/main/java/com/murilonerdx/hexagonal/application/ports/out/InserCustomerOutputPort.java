package com.murilonerdx.hexagonal.application.ports.out;

import com.murilonerdx.hexagonal.application.core.domain.Address;
import com.murilonerdx.hexagonal.application.core.domain.Customer;

public interface InserCustomerOutputPort {
    void insert(Customer customer);
}
