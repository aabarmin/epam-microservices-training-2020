package com.epam.training.microservices.post;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class PostSanitizerVersion1Test {
  private PostSanitizer unitUnderTest;

  @Before
  public void setUp() throws Exception {
    unitUnderTest = new PostSanitizer();
    unitUnderTest.init();
  }

  @Test
  @Ignore
  public void sanitize_shouldCopyText_simple() {
    final String source = "<p>Some text</p>";
    final String target = "<p>Some text</p>";

    final String result = unitUnderTest.sanitize(source);

    assertThat(result).isEqualTo(target);
  }
}