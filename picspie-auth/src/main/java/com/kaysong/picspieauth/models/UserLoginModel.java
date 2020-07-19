package com.kaysong.picspieauth.models;

public class UserLoginModel {

  private String password;
  private String email;

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String userName) {
    this.password = userName;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

}