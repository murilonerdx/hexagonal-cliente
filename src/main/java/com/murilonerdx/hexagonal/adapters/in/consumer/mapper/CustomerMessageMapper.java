package com.murilonerdx.hexagonal.adapters.in.consumer.mapper;

import com.murilonerdx.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.murilonerdx.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {

    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);

}
