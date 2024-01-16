package com.murilonerdx.hexagonal.adapters.out;

import com.murilonerdx.hexagonal.adapters.out.mapper.CustomerEntityMapper;
import com.murilonerdx.hexagonal.adapters.out.repository.CustomerRepository;
import com.murilonerdx.hexagonal.application.core.domain.Customer;
import com.murilonerdx.hexagonal.application.ports.out.InserCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InserCustomerAdapter implements InserCustomerOutputPort {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
