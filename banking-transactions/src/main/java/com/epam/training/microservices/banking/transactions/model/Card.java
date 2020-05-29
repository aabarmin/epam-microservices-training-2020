package com.epam.training.microservices.banking.transactions.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class Card {
  private Long id;

  @NotNull
  private Long accountId;

  @NotNull
  @Size(min = 5, max = 1024)
  private String cardholderName;

  @NotNull
  private LocalDate validBefore;

  @NotNull
  @Size(min = 3, max = 3)
  private String secretCode;

  @NotNull
  @Size(min = 20, max = 20)
  private String number;
}
