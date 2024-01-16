package com.murilonerdx.hexagonal.adapters.out;

import com.murilonerdx.hexagonal.adapters.out.mapper.CustomerEntityMapper;
import com.murilonerdx.hexagonal.adapters.out.repository.CustomerRepository;
import com.murilonerdx.hexagonal.adapters.out.repository.model.CustomerEntity;
import com.murilonerdx.hexagonal.application.core.domain.Customer;
import com.murilonerdx.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import com.murilonerdx.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        Optional<CustomerEntity> byId = customerRepository.findById(id);
        return byId.map(entity -> customerEntityMapper.toCustomer(entity));
    }
}
