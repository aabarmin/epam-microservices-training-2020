package com.epam.training.microservices.banking.transactions.service;

import org.springframework.stereotype.Component;

@Component
public class TaxCalculator {
  public Long withTax(Long amount, Long tax) {
    return amount * (100 + tax) / 100;
  }
}
