package com.prajesh.service.crud;

import com.prajesh.model.Post;
import org.springframework.stereotype.Service;

/**
 * Created by ANAN011 on 12/7/2017.
 *
 * @author Prajesh Ananthan, arvato Systems Malaysia Sdn Bhd
 */

@Service
public class PostServiceCrudImpl implements PostServiceCrud {

  @Override
  public Iterable<Post> list() {
    return null;
  }

  @Override
  public Post create(Post post) {
    return null;
  }

  @Override
  public Post read(long id) {
    return null;
  }

  @Override
  public Post update(long id, Post post) {
    return null;
  }

  @Override
  public void delete(long id) {

  }
}
