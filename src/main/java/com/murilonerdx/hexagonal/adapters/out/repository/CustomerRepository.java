package com.murilonerdx.hexagonal.adapters.out.repository;

import com.murilonerdx.hexagonal.adapters.out.repository.model.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
}
