package com.epam.training.microservices.banking.accounts.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "ACCOUNTS")
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ACCOUNT_ID")
  private Long id;

  @NotNull
  @Column(name = "ACCOUNT_OWNER_ID")
  private Long ownerId;

  @NotNull
  @Column(name = "ACCOUNT_CURRENCY")
  private String accountCurrency;

  @NotNull
  @Column(name = "ACCOUNT_AMOUNT")
  private Long accountAmount;
}
