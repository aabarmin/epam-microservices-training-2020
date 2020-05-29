package com.epam.training.microservices.comment;

import java.util.Collections;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CommentValidatorVersion5Test {
  @Rule
  public final ExpectedException thrown = ExpectedException.none();

  private CommentValidator unitUnderTest = new CommentValidator(Collections.emptyList());

  @Test
  public void isValid_shouldThrowAnException() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Comment is blank");

    unitUnderTest.isValid(null);
  }
}