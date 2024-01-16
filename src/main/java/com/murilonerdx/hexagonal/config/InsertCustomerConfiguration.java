package com.murilonerdx.hexagonal.config;

import com.murilonerdx.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.murilonerdx.hexagonal.adapters.out.InsertCustomerAdapter;
import com.murilonerdx.hexagonal.adapters.out.SendCpfForValidationAdapter;
import com.murilonerdx.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfiguration {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfForValidationAdapter sendCpfForValidationAdapter
    ) {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfForValidationAdapter);
    }

}
