package com.kaysong.picspieauth.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class UserModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(unique = true)
  private String userId;
  @NotBlank(message = "Email cannot be empty")
  @Email
  @Column(unique = true)
  private String email;
  @NotBlank(message = "password cannot be empty")
  @Size(min = 5, message = "Password cannot be less than 5 characters")
  private String password;
  @NotBlank(message = "userName cannot be empty")
  private String userName;

  public String getEmail() {
    return email;
  }

  public Long getId() {
    return id;
  }

  public String getPassword() {
    return password;
  }

  public String getUserId() {
    return userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }
}