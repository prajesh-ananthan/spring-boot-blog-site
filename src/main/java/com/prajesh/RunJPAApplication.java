package com.prajesh;

import com.prajesh.model.Post;
import com.prajesh.repository.PostRepository;
import com.prajesh.service.DataLoaderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class RunJPAApplication {

  private static final Logger log = LoggerFactory.getLogger(RunJPAApplication.class);

  @Autowired
  PostRepository postRepository;

  @Autowired
  DataLoaderService dataLoaderService;

  public static void main(String[] args) {
    SpringApplication.run(RunJPAApplication.class, args);
  }

  @PostConstruct
  public void getPost() {
    log.info("Getting a list of posts.....");
    for (Post post : postRepository.findAll()) {
      log.info(post.toString() + "\n");
    }
  }
}
