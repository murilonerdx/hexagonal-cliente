package com.murilonerdx.hexagonal.adapters.in.controller;

import com.murilonerdx.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.murilonerdx.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.murilonerdx.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.murilonerdx.hexagonal.application.ports.out.InsertCustomerOutputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }
}
