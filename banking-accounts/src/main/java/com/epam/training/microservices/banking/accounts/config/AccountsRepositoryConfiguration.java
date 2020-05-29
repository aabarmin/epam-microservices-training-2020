package com.epam.training.microservices.banking.accounts.config;

import com.epam.training.microservices.banking.accounts.entity.Account;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class AccountsRepositoryConfiguration implements RepositoryRestConfigurer {

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    config.exposeIdsFor(Account.class);
  }
}
