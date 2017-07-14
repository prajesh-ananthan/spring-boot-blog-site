package com.prajesh.controller.crud;

import com.prajesh.service.crud.PostServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Prajesh Ananthan
 *         Created on 13/7/2017.
 */

@RestController
public class PostCrudController {
  private PostServiceCrud postServiceCrud;

  @Autowired
  public PostCrudController(PostServiceCrud postServiceCrud) {
    this.postServiceCrud = postServiceCrud;
  }

  @RequestMapping("/")
  public String home() {
    return "Hello World";
  }
}
