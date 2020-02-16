package com.epam.training.microservices.banking.transactions.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class User {
  private Long id;

  @NotNull
  @Size(min = 5, max = 1024)
  private String userLogin;

  @NotNull
  @Size(min = 5, max = 1024)
  private String userPassword;

  private boolean active;

  @NotNull
  private LocalDate createdDate = LocalDate.now();

  @NotNull
  private LocalDate updatedDate = LocalDate.now();
}
