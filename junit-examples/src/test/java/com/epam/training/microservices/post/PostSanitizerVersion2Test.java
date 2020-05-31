package com.epam.training.microservices.post;

import static org.junit.Assert.assertThat;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.xmlunit.matchers.CompareMatcher;

@Slf4j
public class PostSanitizerVersion2Test {
  private PostSanitizer unitUnderTest;

  @Before
  public void setUp() throws Exception {
    unitUnderTest = new PostSanitizer();
    unitUnderTest.init();
  }

  @Test
  public void sanitize_shouldCopyText_simple() {
    final String source = "<p>Some text</p>";
    final String target = "<p>Some text</p>";

    final String result = unitUnderTest.sanitize(source);

    log.info("Source {}", source);
    log.info("Result {}", result);

    assertThat(result, CompareMatcher.isSimilarTo(target));
  }

  @Test
  public void sanitize_shouldCompareSelfClosedTags() {
    final String source = "<p></p>";
    final String target = "<p />";

    final String result = unitUnderTest.sanitize(source);

    log.info("Source {}", source);
    log.info("Result {}", result);

    assertThat(result, CompareMatcher.isSimilarTo(target));
  }
}