package com.epam.training.microservices.banking;

import com.epam.training.microservices.banking.users.UsersApplication;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@ContextConfiguration(classes = UsersApplication.class)
public abstract class SpringApplicationSupport {
}
