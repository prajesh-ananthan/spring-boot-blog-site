package com.prajesh.controller;

import com.prajesh.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Prajesh Ananthan
 *         Created on 9/7/2017.
 */

// use controller annotation for rendering model page
@Controller
public class HomeController {

  private PostService postService;

  @Autowired
  public HomeController(PostService postService) {
    this.postService = postService;
  }

  @RequestMapping("/")
  public String getLatestPost(Model model) {
    model.addAttribute("post", postService.getLatestPost());
    return "index";
  }
}
