package com.epam.training.microservices.comment;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import lombok.extern.slf4j.Slf4j;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

@Slf4j
public class CommentValidatorVersion6Test {
  @Rule
  public TestName testName = new TestName();

  private final CommentValidator unitUnderTest = new CommentValidator(Collections.emptyList());

  @Test
  public void isValid_checkTestName() {
    log.info("Executing {}", testName.getMethodName());

    assertThat(
        unitUnderTest.isValid(testName.getMethodName())
    ).isTrue();
  }
}