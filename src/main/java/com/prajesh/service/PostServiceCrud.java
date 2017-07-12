package com.prajesh.service;

import com.prajesh.model.Post;

/**
 * Created by ANAN011 on 12/7/2017.
 *
 * @author Prajesh Ananthan, arvato Systems Malaysia Sdn Bhd
 */
public interface PostServiceCrud {
  Iterable<Post> list();

  Post create(Post post);

  Post read(long id);

  Post update(long id, Post post);

  void delete(long id);
}
