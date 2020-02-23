package com.epam.training.microservices.banking;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountsStepDefinition {
  @Given("the system without accounts for {int}")
  public void theSystemWithoutAccountsForOwnerId(int ownerId) {
    System.out.println("Removing all the accounts with ownerId = " + ownerId);
  }

  @When("an account with name {word} and owner {int} is created")
  public void anAccountWithNameNameAndOwnerOwnerIdIsCreated(String accountName, int ownerId) {
    System.out.println(String.format(
            "Creating a new account with name %s and owner %s",
            accountName,
            ownerId
    ));
  }

  @Then("{int} of accounts for {int} exist")
  public void numberOfAccountsForOwnerIdExist(int numberOfAccounts, int ownerId) {
    System.out.println(String.format(
            "Checking if there is only %s accounts for owner %s",
            numberOfAccounts,
            ownerId
    ));
  }
}
