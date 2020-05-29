package com.epam.training.microservices.banking.cards.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "CARDS")
public class Card {
  @Id
  @Column(name = "CARD_ID")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull
  @Column(name = "CARD_ACCOUNT_ID")
  private Long accountId;

  @NotNull
  @Size(min = 5, max = 1024)
  @Column(name = "CARD_HOLDER_NAME")
  private String cardholderName;

  @NotNull
  @Column(name = "CARD_VALID_BEFORE")
  private LocalDate validBefore;

  @NotNull
  @Size(min = 3, max = 3)
  @Column(name = "CARD_CODE")
  private String secretCode;

  @NotNull
  @Size(min = 20, max = 20)
  @Column(name = "CARD_NUMBER")
  private String number;
}
