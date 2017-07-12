package com.prajesh.repository;

import com.prajesh.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Prajesh
 *         Created by Prajesh Ananthan on 9/7/2017.
 */

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
  Post findFirstByOrderByPostedOnDesc();

  List<Post> findAllByOrderByPostedOnDesc();

  Post findBySlug(String slug);

  List<Post> findAllByAuthorFirstName(String firstName);

  List<Post> findAllByAuthorFirstNameIgnoreCase(String firstName);

  List<Post> findAllByAuthorLastNameIgnoreCase(String lastName);


}
