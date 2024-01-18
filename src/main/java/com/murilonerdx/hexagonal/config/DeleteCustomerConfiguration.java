package com.murilonerdx.hexagonal.config;

import com.murilonerdx.hexagonal.application.core.usecase.DeleteCustomerUseCase;
import com.murilonerdx.hexagonal.application.core.usecase.FindCustomerUseCase;
import com.murilonerdx.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.murilonerdx.hexagonal.application.ports.out.DeleteCustomerOutputPort;
import com.murilonerdx.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerConfiguration {

    @Bean
    public DeleteCustomerUseCase findCustomerByIdAdapter(
            FindCustomerByIdInputPort findCustomerByIdInputPort,
            DeleteCustomerOutputPort deleteCustomerOutputPort
    ) {
        return new DeleteCustomerUseCase(findCustomerByIdInputPort, deleteCustomerOutputPort);
    }

}
