package com.murilonerdx.hexagonal.config;

import com.murilonerdx.hexagonal.application.core.usecase.FindCustomerUseCase;
import com.murilonerdx.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfiguration {

    @Bean
    public FindCustomerUseCase findCustomerByIdUseCase(
            FindCustomerByIdOutputPort findCustomerByIdOutputPort
    ) {
        return new FindCustomerUseCase(findCustomerByIdOutputPort);
    }

}
