package com.prajesh.service;

import com.prajesh.model.Post;
import com.prajesh.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Prajesh Ananthan
 *         Created on 10/7/2017.
 */

@Service
public class PostService {
  private PostRepository postRepository;

  @Autowired
  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public Post getLatestPost() {
    return postRepository.findFirstByOrderByPostedOnDesc();
  }
}
