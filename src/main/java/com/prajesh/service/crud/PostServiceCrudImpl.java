package com.prajesh.service.crud;

import com.prajesh.model.Post;
import com.prajesh.repository.AuthorRepository;
import com.prajesh.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by ANAN011 on 12/7/2017.
 *
 * @author Prajesh Ananthan, arvato Systems Malaysia Sdn Bhd
 */

@Service
public class PostServiceCrudImpl implements PostServiceCrud {

  Logger log = LoggerFactory.getLogger(PostServiceCrudImpl.class);

  private PostRepository postRepository;
  private AuthorRepository authorRepository;

  @Autowired
  public PostServiceCrudImpl(PostRepository postRepository, AuthorRepository authorRepository) {
    this.postRepository = postRepository;
    this.authorRepository = authorRepository;
  }

  @Override
  public Iterable<Post> list() {
    return postRepository.findAll();
  }

  @Override
  @Transactional
  public Post create(Post post) {
    return postRepository.save(post);
  }

  @Override
  public Post read(long id) {
    return postRepository.findOne(id);
  }

  @Override
  public Post update(long id, Post update) {
    Post post = postRepository.findOne(id);
    if (update.getTitle() != null) {
      post.setTitle(update.getTitle());
      log.debug("Update on post with title: " + update.getTitle());
    }
    return postRepository.save(post);
  }

  @Override
  public void delete(long id) {
    postRepository.delete(id);
  }
}
