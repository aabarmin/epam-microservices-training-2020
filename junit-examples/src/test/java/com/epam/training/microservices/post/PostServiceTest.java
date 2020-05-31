package com.epam.training.microservices.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PostServiceTest {
  @Mock
  private PostRepository postRepository;

  @Mock
  private PostSanitizer postSanitizer;

  @InjectMocks
  private PostService unitUnderTest;

  @Test
  public void check_contextStarts() {
    assertThat(unitUnderTest).isNotNull();
  }

  @Test
  public void findAll_returnPredefinedAnswer() {
    when(postRepository.findAll()).thenReturn(Collections.singletonList(new Post()));

    final List<Post> result = unitUnderTest.findAll();

    assertThat(result).isNotNull();
    assertThat(result).hasSize(1);
  }

  @Test
  public void findOne_computeReturnValue() {
    when(postRepository.findById(anyInt())).thenAnswer(invocationOnMock -> {
      final Integer id = invocationOnMock.getArgument(0);

      final Post post = new Post();
      post.setId(id);
      return Optional.of(post);
    });

    final Post post = unitUnderTest.findOne(42);

    assertThat(post).isNotNull();
    assertThat(post.getId()).isEqualTo(42);
  }

  @Test
  public void findOne_checkMethodCalled() {
    when(postRepository.findById(anyInt())).thenReturn(Optional.of(new Post()));

    unitUnderTest.findOne(42);

    verify(postRepository, times(1)).findById(anyInt());
  }

  @Test
  public void save_captureValues() {
    final Post post = new Post();
    post.setContent("This is content");

    final Post result = unitUnderTest.save(post);

    final ArgumentCaptor<String> contentCaptor = ArgumentCaptor.forClass(String.class);

    verify(postSanitizer, times(1)).sanitize(contentCaptor.capture());

    final String capturedValue = contentCaptor.getValue();

    assertThat(capturedValue).isEqualTo("This is content");
  }

  @Test
  public void save_captureOrder() {
    final Post post = new Post();
    post.setContent("Content");

    unitUnderTest.save(post);

    final InOrder order = inOrder(postSanitizer, postRepository);

    order.verify(postSanitizer, times(1)).sanitize(anyString());
    order.verify(postRepository, times(1)).save(any(Post.class));
    // change the order to show the failure
  }
}