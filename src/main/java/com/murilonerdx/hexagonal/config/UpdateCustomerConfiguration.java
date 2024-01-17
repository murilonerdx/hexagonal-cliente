package com.murilonerdx.hexagonal.config;

import com.murilonerdx.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.murilonerdx.hexagonal.adapters.out.mapper.CustomerEntityMapper;
import com.murilonerdx.hexagonal.adapters.out.repository.CustomerRepository;
import com.murilonerdx.hexagonal.application.core.usecase.FindCustomerUseCase;
import com.murilonerdx.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import com.murilonerdx.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.murilonerdx.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.murilonerdx.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import com.murilonerdx.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfiguration {

    @Bean
    public UpdateCustomerUseCase updateCustomerAdapter(
            FindCustomerByIdInputPort findCustomerByIdInputPort,
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
            UpdateCustomerOutputPort updateCustomerOutputPort
    ) {
        return new UpdateCustomerUseCase(findCustomerByIdInputPort, findAddressByZipCodeOutputPort, updateCustomerOutputPort);
    }

}
