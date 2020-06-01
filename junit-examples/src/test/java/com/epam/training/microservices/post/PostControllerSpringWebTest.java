package com.epam.training.microservices.post;

import com.epam.training.microservices.comment.CommentValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Collections;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@EnableWebMvc
@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration
public class PostControllerSpringWebTest {
  @MockBean
  private PostRepository postRepository;

  @Autowired
  private WebApplicationContext webContext;

  private MockMvc mockMvc;

  @Before
  public void setUp() throws Exception {
    mockMvc = MockMvcBuilders.webAppContextSetup(webContext)
            .alwaysDo(print())
            .build();

    final Post post = new Post();
    post.setId(1);
    post.setTitle("Post title");
    post.setContent("Post content");
    post.setComments(Collections.emptySet());

    when(postRepository.findAll()).thenReturn(Collections.singletonList(post));
  }

  @Test
  public void findAll_shouldReturnAnswer() throws Exception {
    mockMvc.perform(
            get("/posts")
                    .accept(MediaType.APPLICATION_JSON)
    )
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$[0].id", equalTo(1)))
            .andExpect(jsonPath("$[0].title", equalTo("Post title")))
            .andExpect(jsonPath("$[0].content", equalTo("Post content")));
  }

  @Configuration
  @ComponentScan(basePackageClasses = {
          PostController.class,
          CommentValidator.class
  })
  public static class TestConfig {

  }
}