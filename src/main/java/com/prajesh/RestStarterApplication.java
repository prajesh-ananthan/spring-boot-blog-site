package com.prajesh;

import com.prajesh.model.Author;
import com.prajesh.model.Post;
import com.prajesh.repository.AuthorRepository;
import com.prajesh.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class RestStarterApplication {

  private static final Logger log = LoggerFactory.getLogger(RestStarterApplication.class);

  @Autowired
  PostRepository postRepository;

  public static void main(String[] args) {
    SpringApplication.run(RestStarterApplication.class, args);
  }

  // what is a CommandLineRunner?
  @Bean
  CommandLineRunner runner(AuthorRepository authorRepository, PostRepository postRepository) {
    return args -> {

      log.info("Loading entries from CommandLineRunner...");
      Author dv = new Author("Prajesh", "Ananthan", "j3sh.anand@gmail.com");
      authorRepository.save(dv);

      Post post = new Post("Spring Boot Rocks!");
      post.setSlug("spring-data-rocks");
      post.setTeaser("Post Teaser");
      post.setBody("Post Body");
      post.setPostedOn(new Date());
      post.setAuthor(dv);
      postRepository.save(post);

      Post rest = new Post("REST is what all the cool kids are doing");
      rest.setSlug("rest-is-cool");
      rest.setTeaser("REST Teaser");
      rest.setBody("REST BODY");
      rest.setPostedOn(new Date());
      rest.setAuthor(dv);
      postRepository.save(rest);

      getPost();
    };

  }

  public void getPost() {
    log.info("Getting a list of posts.....");
    postRepository.findAll().forEach(p -> log.info(p.toString() + "\n"));
  }
}
