package com.murilonerdx.hexagonal.adapters.out.client.mapper;

import com.murilonerdx.hexagonal.adapters.out.client.response.AddressResponse;
import com.murilonerdx.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);

}