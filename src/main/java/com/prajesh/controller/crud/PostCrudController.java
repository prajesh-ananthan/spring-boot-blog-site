package com.prajesh.controller.crud;

import com.prajesh.exception.PostNotFoundException;
import com.prajesh.model.Post;
import com.prajesh.service.crud.PostServiceCrud;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Prajesh Ananthan
 *         Created on 13/7/2017.
 */

@RestController
@RequestMapping("/crud")
public class PostCrudController {
  Logger log = LoggerFactory.getLogger(PostCrudController.class);
  private PostServiceCrud postServiceCrud;

  @Autowired
  public PostCrudController(PostServiceCrud postServiceCrud) {
    this.postServiceCrud = postServiceCrud;
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public Iterable<Post> list() {
    return postServiceCrud.list();
  }

  // Get json from client via @RequestBody
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public Post create(@RequestBody Post post) {
    return postServiceCrud.create(post);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Post read(@PathVariable(value = "id") long id) throws PostNotFoundException {
    Post post = postServiceCrud.read(id);
    if (post == null) {
      String message = "Post with id: " + id + " not found!";
      log.error(message);
      throw new PostNotFoundException(message);
    }
    return post;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public Post update(@PathVariable(value = "id") long id, @RequestBody Post post) {
    return postServiceCrud.update(id, post);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable(value = "id") long id) {
    postServiceCrud.delete(id);
  }

  @ExceptionHandler(PostNotFoundException.class)
  public void postNotFoundHandler(PostNotFoundException exception, HttpServletResponse response) throws IOException {
    response.sendError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
  }
}
