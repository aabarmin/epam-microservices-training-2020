package com.epam.training.microservices.comment;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CommentValidatorVersion4Test {
  @Parameter(0)
  public Collection<String> buzzWords;

  @Parameter(1)
  public String comment;

  @Parameter(2)
  public boolean expectedResult;

  @Parameters(name = "{index}: test({1})={2}")
  public static Iterable<Object[]> params() {
    return Arrays.asList(new Object[][]{
        { Arrays.asList("Java"), "Hello, World!", true },
        { Arrays.asList("Java"), "Java sucks!", false }
    });
  }

  private CommentValidator unitUnderTest;

  @Before
  public void setUp() throws Exception {
    unitUnderTest = new CommentValidator(buzzWords);
  }

  @Test
  public void isValid_shouldCheck() {
    final boolean result = unitUnderTest.isValid(comment);

    assertEquals("Invalid result", expectedResult, result);
  }
}