package com.epam.training.microservices.post;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.training.microservices.comment.CommentValidator;
import com.epam.training.microservices.post.PostServiceTestContainersTest.Initializer;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.MySQLContainer;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {
    PostService.class,
    CommentValidator.class,
    PostSanitizer.class
}, initializers = Initializer.class)
@EnableAutoConfiguration
public class PostServiceTestContainersTest {
  @ClassRule
  public static MySQLContainer DATABASE_CONTAINER = new MySQLContainer();

  @Autowired
  private PostService unitUnderTest;

  @Test
  public void check_contextStarts() {
    assertThat(unitUnderTest).isNotNull();
  }

  @Test
  public void save_createsRecord() {
    final Post post = new Post();
    post.setTitle("Post title");
    post.setContent("<p>Post content</p>");

    final Post savedPost = unitUnderTest.save(post);

    assertThat(savedPost).isNotNull();

    final Post foundPost = unitUnderTest.findOne(savedPost.getId());

    assertThat(foundPost).isNotNull();
  }

  static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
      TestPropertyValues.of(
          "spring.datasource.url=" + DATABASE_CONTAINER.getJdbcUrl(),
          "spring.datasource.username=" + DATABASE_CONTAINER.getUsername(),
          "spring.datasource.password=" + DATABASE_CONTAINER.getPassword(),
          "spring.jpa.hibernate.ddl-auto=create-drop"
      ).applyTo(applicationContext.getEnvironment());
    }
  }
}