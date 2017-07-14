package com.prajesh.controller.crud;

import com.prajesh.model.Post;
import com.prajesh.service.crud.PostServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
  public Post read(@PathVariable(value = "id") long id) {
    return postServiceCrud.read(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public Post update(@PathVariable(value = "id") long id, @RequestBody Post post) {
    return postServiceCrud.update(id, post);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable(value = "id") long id) {
    postServiceCrud.delete(id);
  }
}
