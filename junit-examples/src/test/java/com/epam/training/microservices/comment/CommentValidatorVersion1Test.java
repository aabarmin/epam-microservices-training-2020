package com.epam.training.microservices.comment;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import org.junit.Test;

public class CommentValidatorVersion1Test {
  @Test
  public void isValid_shouldBeValid() {
    final CommentValidator unitUnderTest = new CommentValidator(Arrays.asList(
        "Java",
        "Kotlin",
        "Groovy"
    ));

    final boolean result = unitUnderTest.isValid("Hello, World!");

    assertTrue("Result should be valid", result);
  }

  @Test
  public void isValid_shouldNotBeValid() {
    final CommentValidator unitUnderTest = new CommentValidator(Arrays.asList(
        "Java",
        "Kotlin",
        "Groovy"
    ));

    final boolean result = unitUnderTest.isValid("Hello, Java");

    assertFalse("Result should not be valid", result);
  }
}