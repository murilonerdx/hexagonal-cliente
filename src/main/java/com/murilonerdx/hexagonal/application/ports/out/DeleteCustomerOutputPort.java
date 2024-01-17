package com.murilonerdx.hexagonal.application.ports.out;

import com.murilonerdx.hexagonal.application.core.domain.Address;

public interface DeleteCustomerOutputPort {
    void delete(String id);
}
