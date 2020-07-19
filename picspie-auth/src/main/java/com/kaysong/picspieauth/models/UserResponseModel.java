package com.kaysong.picspieauth.models;

public class UserResponseModel {

  private String userName;
  private String email;
  private String userId;

  public UserResponseModel(UserModel userModel) {
    this.userName = userModel.getUserName();
    this.email = userModel.getEmail();
    this.userId = userModel.getUserId();
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getEmail() {
    return email;
  }

  public String getUserName() {
    return userName;
  }

  public String getUserId() {
    return userId;
  }
}