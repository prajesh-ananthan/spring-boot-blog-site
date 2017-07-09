package com.prajesh.repository;

import com.prajesh.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Prajesh
 *         Created by Prajesh Ananthan on 9/7/2017.
 */

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
  Post findFirstByOrderByPostedOnDesc();
}
