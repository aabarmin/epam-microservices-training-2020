package com.epam.training.microservices.comment;

import java.util.concurrent.TimeUnit;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.Timeout;

public class CommentValidatorVersion9Test {
  @Rule
  public DisableOnDebug disableTimeout = new DisableOnDebug(Timeout.seconds(1));

  @Test
  @Ignore
  public void timeout_worksInDebug() throws Exception {
    TimeUnit.SECONDS.sleep(5);
  }
}