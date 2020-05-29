package com.epam.training.microservices.banking.transactions.service;

import com.epam.training.microservices.banking.transactions.client.CardsClient;
import com.epam.training.microservices.banking.transactions.model.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardsService {
  private final CardsClient cardsClient;

  public Card findOne(Long id) {
    return cardsClient.findOne(id)
            .getContent();
  }
}
