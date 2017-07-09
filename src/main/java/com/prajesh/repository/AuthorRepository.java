package com.prajesh.repository;

import com.prajesh.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Prajesh
 *         Created by Prajesh Ananthan on 9/7/2017.
 */

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
