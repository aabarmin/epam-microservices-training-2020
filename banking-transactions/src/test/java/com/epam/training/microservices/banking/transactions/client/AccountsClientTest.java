package com.epam.training.microservices.banking.transactions.client;

import com.epam.training.microservices.banking.transactions.model.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.hateoas.CollectionModel;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        properties = {
                "service.accounts.url=http://localhost:8082/"
        }
)
@AutoConfigureStubRunner(
        ids = {"com.epam.training.microservices:banking-accounts-contract:+:stubs:8082"},
        stubsMode = StubRunnerProperties.StubsMode.LOCAL
)
class AccountsClientTest {

  @Autowired
  private AccountsClient accountsClient;

  @Test
  public void accounts_returnsList() throws Exception {
    final CollectionModel<Account> accounts = accountsClient.findAll();

    assertAll(
            () -> assertNotNull(accounts)
    );
  }
}