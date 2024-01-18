package com.murilonerdx.hexagonal.adapters.in.controller;

import com.murilonerdx.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.murilonerdx.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.murilonerdx.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.murilonerdx.hexagonal.application.core.domain.Customer;
import com.murilonerdx.hexagonal.application.ports.in.DeleteCustomerInputPort;
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

    private final InsertCustomerInputPort insertCustomerInputPort;

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final UpdateCustomerInputPort updateCustomerInputPort;

    private final DeleteCustomerInputPort deleteCustomerInputPort;

    private final CustomerMapper customerMapper;

    public CustomerController(CustomerMapper customerMapper, DeleteCustomerInputPort deleteCustomerInputPort, InsertCustomerInputPort insertCustomerInputPort, FindCustomerByIdInputPort findCustomerByIdInputPort, UpdateCustomerInputPort updateCustomerInputPort) {
        this.customerMapper = customerMapper;
        this.deleteCustomerInputPort = deleteCustomerInputPort;
        this.insertCustomerInputPort = insertCustomerInputPort;
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.updateCustomerInputPort = updateCustomerInputPort;
    }

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable String id) {
        deleteCustomerInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
