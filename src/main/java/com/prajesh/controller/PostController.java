package com.prajesh.controller;

import com.prajesh.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}