package com.kaysong.picspiecomment.models;

public class CommentResponseModel {

  private String userId;
  private String commentId;
  private String content;

  public void setCommentId(String commentId) {
    this.commentId = commentId;
  }

  public void setContent(String content) {
    this.content = content;
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

  public String getUserId() {
    return userId;
  }
}