package com.epam.training.microservices.banking.transactions;

import com.epam.training.microservices.banking.transactions.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transactions")
public class TransactionsController {
  private final TransactionService transactionService;

  @GetMapping("/transfer/{accountFromId}/{accountToId}/{amount}")
  public void transfer(@PathVariable("accountFromId") Long accountFromId,
                       @PathVariable("accountToId") Long accountToId,
                       @PathVariable("amount") Long amount) {

    transactionService.transfer(accountFromId, accountToId, amount);
  }

  @GetMapping("/deposit/{accountId}/{amount}")
  public void deposit(@PathVariable("accountId") Long accountId,
                      @PathVariable("amount") Long amount) {

    transactionService.deposit(accountId, amount);
  }
}
