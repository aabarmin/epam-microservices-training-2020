package com.epam.training.microservices.banking.transactions.client;

import com.epam.training.microservices.banking.transactions.model.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "accountsClient", url = "${service.accounts.url}")
public interface AccountsClient {
  @RequestMapping(method = RequestMethod.GET, value = "/accounts")
  CollectionModel<Account> findAll();

  @RequestMapping(method = RequestMethod.GET, value = "/accounts/{accountId}")
  EntityModel<Account> findOne(@PathVariable("accountId") Long accountId);

  @RequestMapping(method = RequestMethod.PUT, value = "/accounts/{accountId}")
  EntityModel<Account> save(@PathVariable("accountId") Long accountId,
                            Account account);
}
