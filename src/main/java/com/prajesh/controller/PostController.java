package com.prajesh.controller;

import com.prajesh.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ANAN011 on 11/7/2017.
 *
 * @author Prajesh Ananthan, arvato Systems Malaysia Sdn Bhd
 */
@Controller
public class PostController {

  private Logger LOG = LoggerFactory.getLogger(PostController.class);

  private PostService postService;

  @Autowired
  public PostController(PostService postService) {
    this.postService = postService;
  }

  @RequestMapping("/posts/list")
  public String listPost(Model model) {
    model.addAttribute("posts", postService.getPosts());
    return "post/view";
  }

  // Get the post by slug name
//  @RequestMapping("/posts/view/{slug}")
//  public String getSlug(@PathVariable(value="slug") String slug, Model model) {
//    model.addAttribute("post", postService.findBySlug(slug));
//    return "/view";
//  }
}
