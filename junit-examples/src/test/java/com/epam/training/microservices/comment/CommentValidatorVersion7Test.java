package com.epam.training.microservices.comment;

import java.util.concurrent.TimeUnit;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class CommentValidatorVersion7Test {
  @Rule
  public Timeout timeout = Timeout.seconds(5);

  @Test
  public void timeout_waitThreeSeconds() throws Exception {
    TimeUnit.SECONDS.sleep(1);
  }

  @Test
  @Ignore
  public void timeout_waitTenSeconds() throws Exception {
    TimeUnit.SECONDS.sleep(10);
  }
}