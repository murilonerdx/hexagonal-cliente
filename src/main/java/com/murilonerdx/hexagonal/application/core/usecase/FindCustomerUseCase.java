package com.murilonerdx.hexagonal.application.core.usecase;

import com.murilonerdx.hexagonal.application.core.domain.Customer;
import com.murilonerdx.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

import java.util.Optional;

public class FindCustomerUseCase {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public FindCustomerUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    public Customer find(String id)  {
        return findCustomerByIdOutputPort.find(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
