package com.epam.training.microservices.comment;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@Slf4j
public class CommentValidatorVersion2Test {
  private CommentValidator unitUnderTest;

  @Before
  public void setUp() throws Exception {
    log.info("Set up is called");

    unitUnderTest = new CommentValidator(Arrays.asList(
        "Java",
        "Kotlin",
        "Groovy"
    ));
  }

  @After
  public void tearDown() throws Exception {
    log.info("Tear down is called");
    // clean up caches, dbs, etc.
  }

  @Test
  public void isValid_shouldBeValid() {
    final boolean result = unitUnderTest.isValid("Hello, World!");

    assertTrue("Comment should be valid", result);
  }

  @Test
  public void isValid_shouldNotBeValid() {
    final boolean result = unitUnderTest.isValid("Hello, Java");

    assertFalse("Comment should not be valid", result);
  }
}