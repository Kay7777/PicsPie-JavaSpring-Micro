package com.kaysong.picspieauth.web;

import javax.validation.Valid;

import com.kaysong.picspieauth.models.UserModel;
import com.kaysong.picspieauth.models.UserResponseModel;
import com.kaysong.picspieauth.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/status")
  public String getStatus() {
    return "Auth Server is Working";
  }

  @PostMapping("/signup")
  public ResponseEntity<UserResponseModel> createUser(@Valid @RequestBody UserModel userModel) {
    UserResponseModel userModel1 = userService.createUser(userModel);
    return new ResponseEntity<UserResponseModel>(userModel1, HttpStatus.CREATED);
  }

  @GetMapping("/{userId}")
  public ResponseEntity<UserResponseModel> getUserByUserId(@PathVariable String userId) {
    UserResponseModel userResponseModel = userService.getUserByUserId(userId);
    return new ResponseEntity<UserResponseModel>(userResponseModel, HttpStatus.OK);
  }
}