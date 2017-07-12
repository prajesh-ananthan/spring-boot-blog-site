package com.prajesh.controller;

import com.prajesh.model.Post;
import com.prajesh.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Prajesh Ananthan
 *         Created on 12/7/2017.
 */
@Controller
public class PostController {

  private PostService postService;

  @Autowired
  public PostController(PostService postService) {
    this.postService = postService;
  }

  @RequestMapping("/posts/list")
  public String listPosts(Model model) {
    model.addAttribute("posts", postService.getPosts());
    return "post/list";
  }

  @RequestMapping("/posts/view/{slug}")
  public String getPost(@PathVariable(value = "slug") String slug, Model model) {
    model.addAttribute("post", postService.getBySlug(slug));
    return "post/view";
  }

  @RequestMapping("/post/{id}")
  @ResponseBody
  public Post getPath(@PathVariable(value = "id") Long id) {
    return postService.findPostById(id);
  }

  @RequestMapping("/authorFirst/{firstName}")
  @ResponseBody
  public List<Post> byAuthor(@PathVariable(value = "firstName") String firstName) {
    return postService.findbyAuthorFirstName(firstName);
  }

  @RequestMapping("/authorLast/{lastName}")
  @ResponseBody
  public List<Post> byAuthorLastName(@PathVariable(value = "lastName") String lastName) {
    return postService.findbyAuthorLastName(lastName);
  }
}
