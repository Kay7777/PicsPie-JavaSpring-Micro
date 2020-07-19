package com.kaysong.picspiepost.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class PostModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;
  @NotBlank(message = "title cannot be empty")
  private String title;
  @NotBlank(message = "content cannot be empty")
  private String content;
  private String[] pictures;
  private String[] videos;
  @NotBlank(message = "userId cannot be empty")
  private String userId;
  private String postId;

  public void setContent(String content) {
    this.content = content;
  }

  public void setId(Long id) {
    Id = id;
  }

  public void setPictures(String[] pictures) {
    this.pictures = pictures;
  }

  public void setPostId(String postId) {
    this.postId = postId;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public void setVideos(String[] videos) {
    this.videos = videos;
  }

  public String getContent() {
    return content;
  }

  public Long getId() {
    return Id;
  }

  public String[] getPictures() {
    return pictures;
  }

  public String getPostId() {
    return postId;
  }

  public String getTitle() {
    return title;
  }

  public String getUserId() {
    return userId;
  }

  public String[] getVideos() {
    return videos;
  }

}