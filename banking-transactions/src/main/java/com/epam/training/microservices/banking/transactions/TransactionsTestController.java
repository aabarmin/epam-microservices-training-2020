package com.epam.training.microservices.banking.transactions;

import com.epam.training.microservices.banking.transactions.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transactions")
public class TransactionsTestController {
  private final TransactionService transactionService;

  @GetMapping("")
  public void test() {
    transactionService.withdraw(1L, 100L);
  }
}
