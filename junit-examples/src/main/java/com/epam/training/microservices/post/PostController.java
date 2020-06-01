package com.epam.training.microservices.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
  private final PostService postService;

  @GetMapping("")
  public List<Post> findAll() {
    return postService.findAll();
  }

  @GetMapping("/{id}")
  public Post findOne(@PathVariable("id") int id) {
    return postService.findOne(id);
  }

  @PostMapping("/")
  public Post save(@RequestBody Post post) {
    return postService.save(post);
  }
}
