package com.murilonerdx.hexagonal.adapters.out.repository.model;

import com.murilonerdx.hexagonal.application.core.domain.Address;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "customers")
public class CustomerEntity {
    @Id
    private String id;
    private String name;
    private AddressEntity address;
    private String suid;
    private Boolean isValidCpf;
}
