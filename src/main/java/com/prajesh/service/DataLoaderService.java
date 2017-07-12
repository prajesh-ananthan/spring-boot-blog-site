package com.prajesh.service;

import com.prajesh.model.Author;
import com.prajesh.model.Post;
import com.prajesh.repository.AuthorRepository;
import com.prajesh.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * @author Prajesh
 *         Created by Prajesh Ananthan on 9/7/2017.
 */
@Service
public class DataLoaderService {

  private static final Logger log = LoggerFactory.getLogger(DataLoaderService.class);

  private AuthorRepository authorRepository;
  private PostRepository postRepository;

  @Autowired
  public DataLoaderService(AuthorRepository authorRepository, PostRepository postRepository) {
    this.authorRepository = authorRepository;
    this.postRepository = postRepository;
  }

  @PostConstruct
  private void loadData() {
    log.info("Loading data from POJO..");
    Author author = new Author();
    author.setFirstName("Divya");
    author.setLastName("Garg");
    authorRepository.save(author);

    Post post = new Post();
    post.setAuthor(author);
    post.setPostedOn(new Date());
    post.setTitle("Spring Boot");
    post.setBody("Spring Boot rocks!");
    postRepository.save(post);
  }
}
