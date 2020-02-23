package com.epam.training.microservices.banking;

import com.epam.training.microservices.banking.users.entity.User;
import com.epam.training.microservices.banking.users.repository.UserRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserServiceStepDefinitions extends SpringApplicationSupport {
  @Autowired
  private UserRepository userRepository;

  private List<User> users;

  @Given("the system has no users registered")
  public void theSystemHasNoUsersRegistered() {
    userRepository.deleteAll();
    users = new ArrayList<>();
  }

  @When("all the users are requested")
  public void allTheUsersAreRequested() {
    users = toCollection(userRepository.findAll());
  }

  @Then("{int} users are returned")
  public void usersAreReturned(int numberOfUsers) {
    assertThat(users.size(), is(numberOfUsers));
  }



  private <T> List<T> toCollection(Iterable<T> iterable) {
    final List<T> items = new ArrayList<>();
    for (T item : iterable) {
      items.add(item);
    }
    return items;
  }

  @When("a new active user with login {word} and password {word} is created")
  public void createNewUser(String login, String password) {
    final User user = new User();
    user.setActive(true);
    user.setUserLogin(login);
    user.setUserPassword(password);

    userRepository.save(user);
  }
}
