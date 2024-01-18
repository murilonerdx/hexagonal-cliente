package com.murilonerdx.hexagonal.adapters.in.consumer.message;

import com.murilonerdx.hexagonal.application.core.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class CustomerMessage {
    private String id;

    private String name;

    private String zipCode;

    private String suid;

    private Boolean isValidCpf;
}
