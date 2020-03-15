package com.epam.training.microservices.banking;

import com.epam.training.microservices.banking.accounts.AccountsApplication;
import com.epam.training.microservices.banking.accounts.repository.AccountRepository;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = AccountsApplication.class
)
@DirtiesContext
@AutoConfigureMessageVerifier
public class BaseTestClass {
  @Autowired
  private AccountRepository accountRepository;

  @BeforeEach
  public void setup(WebApplicationContext webApplicationContext) {
    RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
  }
}