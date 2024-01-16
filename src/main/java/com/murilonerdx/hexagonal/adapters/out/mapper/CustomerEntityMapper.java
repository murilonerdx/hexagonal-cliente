package com.murilonerdx.hexagonal.adapters.out.mapper;

import com.murilonerdx.hexagonal.adapters.out.repository.model.CustomerEntity;
import com.murilonerdx.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {
    CustomerEntity toCustomerEntity(Customer customer);
}
