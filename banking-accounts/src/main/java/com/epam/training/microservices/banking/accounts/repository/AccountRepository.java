package com.epam.training.microservices.banking.accounts.repository;

import com.epam.training.microservices.banking.accounts.entity.Account;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "accounts")
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {
  List<Account> findAllByOwnerId(@Param("ownerId") Long id);
}
