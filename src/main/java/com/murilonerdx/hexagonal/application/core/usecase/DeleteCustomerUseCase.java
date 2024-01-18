package com.murilonerdx.hexagonal.application.core.usecase;

import com.murilonerdx.hexagonal.application.core.domain.Customer;
import com.murilonerdx.hexagonal.application.ports.in.DeleteCustomerInputPort;
import com.murilonerdx.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.murilonerdx.hexagonal.application.ports.out.DeleteCustomerOutputPort;

public class DeleteCustomerUseCase implements DeleteCustomerInputPort {
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final DeleteCustomerOutputPort deleteCustomerOutputPort;

    public DeleteCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort, DeleteCustomerOutputPort deleteCustomerOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerOutputPort = deleteCustomerOutputPort;
    }

    @Override
    public void delete(String id){
        Customer customer = findCustomerByIdInputPort.find(id);
        deleteCustomerOutputPort.delete(customer.getId());
    }
}
