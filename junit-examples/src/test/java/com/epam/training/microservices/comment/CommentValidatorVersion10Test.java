package com.epam.training.microservices.comment;

import java.io.File;
import java.nio.file.Files;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class CommentValidatorVersion10Test {
  @Rule
  public TemporaryFolder temporaryFolder = new TemporaryFolder();

  @Test
  public void isValid_tempFolderShouldExist() throws Exception {
    final File tempFolder = temporaryFolder.newFolder();

    Files.exists(tempFolder.toPath());
  }
}