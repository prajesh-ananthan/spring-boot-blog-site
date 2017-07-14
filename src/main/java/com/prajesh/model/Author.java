package com.prajesh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Prajesh
 *         Created by Prajesh Ananthan on 9/7/2017.
 */

@Entity
public class Author {

  @Id
  @GeneratedValue
  private int id;
  private String firstName;
  private String lastName;
  private String email;

// Commented out, causing stackoverflow upon query
//  @OneToMany(mappedBy = "author")
//  private List<Post> posts;

//  public List<Post> getPosts() {
//    return posts;
//  }
//
//  public void setPosts(List<Post> posts) {
//    this.posts = posts;
//  }

  public Author() {
  }

  public Author(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

}
