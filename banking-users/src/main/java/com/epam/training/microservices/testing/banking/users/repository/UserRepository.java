package com.epam.training.microservices.testing.banking.users.repository;

import com.epam.training.microservices.testing.banking.users.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "users", collectionResourceRel = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
