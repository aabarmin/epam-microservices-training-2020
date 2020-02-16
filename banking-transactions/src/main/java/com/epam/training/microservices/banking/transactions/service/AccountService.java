package com.epam.training.microservices.banking.transactions.service;

import com.epam.training.microservices.banking.transactions.client.AccountsClient;
import com.epam.training.microservices.banking.transactions.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
  private final AccountsClient accountsClient;

  @Nullable public Account findOne(Long accountId) {
    return accountsClient.findOne(accountId)
            .getContent();
  }

  public Account save(Account account) {
    return accountsClient.save(account.getId(), account)
            .getContent();
  }
}
