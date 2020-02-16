package com.epam.training.microservices.banking.transactions.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Account {
  private Long id;

  @NotNull
  private Long ownerId;

  @NotNull
  private String accountCurrency;

  @NotNull
  private Long accountAmount;
}
