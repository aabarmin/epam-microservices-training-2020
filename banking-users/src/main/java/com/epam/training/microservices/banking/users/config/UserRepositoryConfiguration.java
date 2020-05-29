package com.epam.training.microservices.banking.users.config;

import com.epam.training.microservices.banking.users.entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class UserRepositoryConfiguration implements RepositoryRestConfigurer {
  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    config.exposeIdsFor(User.class);
  }
}
