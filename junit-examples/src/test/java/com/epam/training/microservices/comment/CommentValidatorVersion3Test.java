package com.epam.training.microservices.comment;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class CommentValidatorVersion3Test {
  private CommentValidator unitUnderTest;

  @Before
  public void setUp() throws Exception {
    unitUnderTest = new CommentValidator(Arrays.asList(
        "Java",
        "Kotlin",
        "Groovy"
    ));
  }

  @Test
  public void isValid_shouldBeValid() {
    final boolean result = unitUnderTest.isValid("Hello, World");

    assertThat(result).isTrue();
  }

  @Test
  public void isValid_shouldNotBeValid() {
    final boolean result = unitUnderTest.isValid("Hello, Java");

    assertThat(result).isFalse();
  }

  @Test(expected = IllegalArgumentException.class)
  public void isValid_exceptionIfContentIsEmpty() {
    unitUnderTest.isValid("");
  }
}