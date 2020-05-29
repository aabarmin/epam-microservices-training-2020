package com.epam.training.microservices.banking.transactions.service;

import com.epam.training.microservices.banking.transactions.model.Account;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
  private final AccountService accountService;
  private final TaxCalculator taxCalculator;
  private final Long taxPercentage;

  public TransactionService(AccountService accountService,
                            TaxCalculator taxCalculator,
                            @Value("${tax.percentage}") Long taxPercentage) {
    this.accountService = accountService;
    this.taxCalculator = taxCalculator;
    this.taxPercentage = taxPercentage;
  }


  public boolean withdraw(Long accountId, Long amount) {
    final Account account = accountService.findOne(accountId);
    if (account == null) {
      throw new NoAccountException();
    }
    if (account.getAccountAmount() < amount) {
      throw new NotEnoughMoneyException();
    }
    account.setAccountAmount(account.getAccountAmount() - amount);
    accountService.save(account);
    return true;
  }

  public boolean deposit(Long accountId, Long amount) {
    final Account account = accountService.findOne(accountId);
    if (account == null) {
      throw new NoAccountException();
    }
    account.setAccountAmount(account.getAccountAmount() + amount);
    accountService.save(account);
    return true;
  }

  public boolean transfer(Long accountFromId, Long accountToId, Long amount) {
    final Long amountWithTax = taxCalculator.withTax(amount, taxPercentage);
    withdraw(accountFromId, amountWithTax);
    deposit(accountToId, amount);
    return true;
  }
}
