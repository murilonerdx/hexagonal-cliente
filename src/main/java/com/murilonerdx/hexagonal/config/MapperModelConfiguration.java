package com.murilonerdx.hexagonal.config;

import com.murilonerdx.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.murilonerdx.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.murilonerdx.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.murilonerdx.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.murilonerdx.hexagonal.adapters.in.controller.response.AddressResponse;
import com.murilonerdx.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.murilonerdx.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.murilonerdx.hexagonal.adapters.out.mapper.CustomerEntityMapper;
import com.murilonerdx.hexagonal.adapters.out.repository.model.AddressEntity;
import com.murilonerdx.hexagonal.adapters.out.repository.model.CustomerEntity;
import com.murilonerdx.hexagonal.application.core.domain.Address;
import com.murilonerdx.hexagonal.application.core.domain.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperModelConfiguration {

    @Bean
    CustomerMapper customerMapper() {
        return new CustomerMapper() {
            @Override
            public Customer toCustomer(CustomerRequest customerRequest) {
                return new Customer(null,
                        customerRequest.getName(),
                        null,
                        customerRequest.getCpf(),
                        null
                );
            }

            @Override
            public CustomerResponse toCustomerResponse(Customer customer) {
                Address address = customer.getAddress();
                AddressResponse addressResponse = AddressResponse.builder()
                        .state(address.getState())
                        .street(address.getStreet())
                        .city(address.getCity())
                        .build();

                return CustomerResponse.builder()
                        .cpf(customer.getSuid())
                        .isValidCpf(customer.getValidCpf())
                        .name(customer.getName())
                        .address(addressResponse)
                        .build();
            }
        };
    }

    @Bean
    AddressResponseMapper addressResponseMapper(){
        return new AddressResponseMapper() {
            @Override
            public Address toAddress(com.murilonerdx.hexagonal.adapters.out.client.response.AddressResponse addressResponse) {
                return new Address(
                        addressResponse.getStreet(),
                        addressResponse.getCity(),
                        addressResponse.getState()
                );
            }
        };
    }

    @Bean
    CustomerMessageMapper customerMessageMapper(){
        return new CustomerMessageMapper() {
            @Override
            public Customer toCustomer(CustomerMessage customerMessage) {
                return new Customer(null,
                        customerMessage.getName(),
                        null,
                        customerMessage.getSuid(),
                        customerMessage.getIsValidCpf()
                );
            }
        };
    }


    @Bean
    CustomerEntityMapper customerEntityMapper(){
        return new CustomerEntityMapper() {
            @Override
            public CustomerEntity toCustomerEntity(Customer customer) {
                Address address = customer.getAddress();
                AddressEntity addressResponse = AddressEntity.builder()
                        .state(address.getState())
                        .street(address.getStreet())
                        .city(address.getCity())
                        .build();

                return CustomerEntity.builder()
                        .suid(customer.getSuid())
                        .address(addressResponse)
                        .name(customer.getName())
                        .isValidCpf(customer.getValidCpf())
                        .id(customer.getId()).build();
            }

            @Override
            public Customer toCustomer(CustomerEntity customerEntity) {
                AddressEntity address = customerEntity.getAddress();
                Address addressResponse = new Address(
                        address.getStreet(),
                        address.getCity(),
                        address.getState()
                );
                return new Customer(null,
                        customerEntity.getName(),
                        addressResponse,
                        customerEntity.getSuid(),
                        customerEntity.getIsValidCpf()
                );
            }
        };
    }
}
