package com.epam.training.microservices.banking.cards.config;

import com.epam.training.microservices.banking.cards.entity.Card;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class CardsRepositoryConfiguration implements RepositoryRestConfigurer {
  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    config.exposeIdsFor(Card.class);
  }
}
