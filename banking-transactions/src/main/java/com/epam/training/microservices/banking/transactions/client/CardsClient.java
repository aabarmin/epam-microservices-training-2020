package com.epam.training.microservices.banking.transactions.client;

import com.epam.training.microservices.banking.transactions.model.Card;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "cardsClient", url = "${service.cards.url}")
public interface CardsClient {
  @RequestMapping(method = RequestMethod.GET, value = "/cards")
  CollectionModel<Card> findAll();

  @RequestMapping(method = RequestMethod.GET, value = "/cards/{cardId}")
  EntityModel<Card> findOne(@PathVariable("cardId") Long id);
}
