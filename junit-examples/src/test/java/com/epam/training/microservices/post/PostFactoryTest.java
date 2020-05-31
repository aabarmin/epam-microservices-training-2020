package com.epam.training.microservices.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({PostFactory.class, CommentUtils.class})
public class PostFactoryTest {
  private PostFactory unitUnderTest;

  @Before
  public void setUp() throws Exception {
    unitUnderTest = PowerMockito.spy(new PostFactory());
  }

  @Test
  public void createNew_shouldReturnNewPost() {
    final Post post = unitUnderTest.createNew();

    assertThat(post).isNotNull();
    assertThat(post.getTitle()).isEqualTo("New post");
    assertThat(post.getContent()).isEmpty();
    assertThat(post.getComments()).isEmpty();
  }

  @Test
  public void createNew_mockPrivateMethod() throws Exception {
    final Post post = new Post();
    post.setContent("Dummy content");

    when(unitUnderTest, "createEmptyPost").thenReturn(post);

    final Post newPost = unitUnderTest.createNew();

    assertThat(newPost).isNotNull();
    assertThat(newPost.getTitle()).isEqualTo("New post");
    assertThat(newPost.getContent()).isEqualTo("Dummy content");
    assertThat(newPost.getComments()).isEmpty();
  }

  @Test
  public void createNew_mockStaticMethod() {
    mockStatic(CommentUtils.class);

    when(CommentUtils.generateEmptyComments()).thenReturn(Collections.singleton(new Comment()));

    final Post newPost = unitUnderTest.createNew();

    assertThat(newPost).isNotNull();
    assertThat(newPost.getTitle()).isEqualTo("New post");
    assertThat(newPost.getContent()).isEmpty();
    assertThat(newPost.getComments()).hasSize(1);
  }
}