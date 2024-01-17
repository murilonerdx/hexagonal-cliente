package com.murilonerdx.hexagonal.application.core.usecase;

import com.murilonerdx.hexagonal.application.core.domain.Customer;
import com.murilonerdx.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.murilonerdx.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.murilonerdx.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.murilonerdx.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort, FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, UpdateCustomerOutputPort updateCustomerOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    @Override
    public void update(Customer custom, String zipCode) {
        var customer = findCustomerByIdInputPort.find(custom.getId());
        var address = findAddressByZipCodeOutputPort.find(zipCode);

        customer.setAddress(address);
        updateCustomerOutputPort.update(customer);
    }
}
