package com.murilonerdx.hexagonal.application.core.usecase;

import com.murilonerdx.hexagonal.application.core.domain.Customer;
import com.murilonerdx.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.murilonerdx.hexagonal.application.ports.out.InserCustomerOutputPort;

public class InsertCustomerUseCase {
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InserCustomerOutputPort inserCustomerOutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, InserCustomerOutputPort inserCustomerOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.inserCustomerOutputPort = inserCustomerOutputPort;
    }

    public void insert(Customer customer, String zipCode){
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        inserCustomerOutputPort.insert(customer);
    }
}
