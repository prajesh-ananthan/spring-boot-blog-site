package com.prajesh.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Prajesh
 *         Created by Prajesh Ananthan on 9/7/2017.
 */

@Entity
public class Post {

  @Id
  @GeneratedValue
  private Long id;
  private String title;

  @Column(columnDefinition = "TEXT")
  private String body;

  @CreatedDate
  @Column(columnDefinition = "TIMESTAMP")
  private Date postedOn;

  @Column(columnDefinition = "TEXT")
  private String teaser;

  @Column(columnDefinition = "TEXT")
  private String slug;

  @ManyToOne
  private Author author;

  @SuppressWarnings("unused")
  public Post() {
  }

  public Post(String title) {
    this.title = title;
  }

  public String getTeaser() {
    return teaser;
  }

  public void setTeaser(String teaser) {
    this.teaser = teaser;
  }

  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public Date getPostedOn() {
    return postedOn;
  }

  public void setPostedOn(Date postedOn) {
    this.postedOn = postedOn;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Post{");
    sb.append("id=").append(id);
    sb.append(", title='").append(title).append('\'');
    sb.append(", body='").append(body).append('\'');
    sb.append(", postedOn=").append(postedOn);
    sb.append(", teaser='").append(teaser).append('\'');
    sb.append(", slug='").append(slug).append('\'');
    sb.append(", author=").append(author);
    sb.append('}');
    return sb.toString();
  }
}
