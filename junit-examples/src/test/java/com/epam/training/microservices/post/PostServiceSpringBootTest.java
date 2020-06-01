package com.epam.training.microservices.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceSpringBootTest {
  @Autowired
  private PostService unitUnderTest;

  @Test
  public void check_contextStarts() {
    assertThat(unitUnderTest).isNotNull();
  }

  @Test
  public void save_savesPost() {
    final Post post = new Post();
    post.setContent("<p>Post content</p>");
    post.setTitle("Post title");

    final Post savedPost = unitUnderTest.save(post);

    assertThat(savedPost).isNotNull();
  }
}