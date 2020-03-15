package com.epam.training.microservices.banking;

import lombok.Data;

@Data
public class Account {
  private Long id;

  private Long ownerId;

  private String accountCurrency;

  private Long accountAmount;
}
