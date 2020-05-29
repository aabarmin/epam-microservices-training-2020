package com.epam.training.microservices.comment;

import java.util.Collections;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

@Slf4j
public class CommentValidatorVersion8Test {
  private final CommentValidator unitUnderTest = new CommentValidator(Collections.emptyList());

  @Rule
  public ErrorCollector errorCollector = new ErrorCollector();

  @Test
  @Ignore
  public void isValid_shouldCollectErrors() {
    try {
      unitUnderTest.isValid(null);
    } catch (Exception e) {
      errorCollector.addError(e);
    }

    log.info("This code is executed");

    errorCollector.checkSucceeds(() -> {
      return unitUnderTest.isValid(null);
    });

    log.info("This code is executed too");
  }
}