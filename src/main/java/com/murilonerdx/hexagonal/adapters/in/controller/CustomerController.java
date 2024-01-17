package com.murilonerdx.hexagonal.adapters.in.controller;

import com.murilonerdx.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.murilonerdx.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.murilonerdx.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.murilonerdx.hexagonal.application.core.domain.Customer;
import com.murilonerdx.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.murilonerdx.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.murilonerdx.hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> insert(@Valid @PathVariable String id) {
        return ResponseEntity.ok(customerMapper.toCustomerResponse(findCustomerByIdInputPort.find(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @PathVariable String id,@Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }
}
