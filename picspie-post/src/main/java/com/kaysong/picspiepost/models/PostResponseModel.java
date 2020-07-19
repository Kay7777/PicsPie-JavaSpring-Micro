package com.kaysong.picspiepost.models;

public class PostResponseModel {

  private String userId;
  private String postId;
  private String[] pictures;
  private String[] videos;
  private String title;
  private String content;

  public void setContent(String content) {
    this.content = content;
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