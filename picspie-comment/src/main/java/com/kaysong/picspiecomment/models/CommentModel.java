package com.kaysong.picspiecomment.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class CommentModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;
  @Column(unique = true)
  private String commentId;
  @NotBlank(message = "userId cannot be empty")
  private String userId;
  @NotBlank(message = "postId cannot be empty")
  private String postId;
  @NotBlank(message = "content cannot be empty")
  private String content;

  public void setCommentId(String commentId) {
    this.commentId = commentId;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void setId(Long id) {
    Id = id;
  }

  public void setPostId(String postId) {
    this.postId = postId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getCommentId() {
    return commentId;
  }

  public String getContent() {
    return content;
  }

  public Long getId() {
    return Id;
  }

  public String getPostId() {
    return postId;
  }

  public String getUserId() {
    return userId;
  }
}