package com.kaysong.picspieauth.services;

import java.util.ArrayList;
import java.util.UUID;

import com.kaysong.picspieauth.models.UserModel;
import com.kaysong.picspieauth.models.UserResponseModel;
import com.kaysong.picspieauth.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UserService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  public UserResponseModel createUser(UserModel userModel) {
    userModel.setUserId(UUID.randomUUID().toString());
    userModel.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
    UserModel userModel1 = userRepository.save(userModel);
    UserResponseModel userResponseModel = new UserResponseModel(userModel1);
    return userResponseModel;
  }

  public UserModel getUserByEmail(String email) {
    UserModel userModel = userRepository.findByEmail(email);
    if (userModel == null)
      throw new UsernameNotFoundException(email);
    return userModel;
  }

  public UserResponseModel getUserByUserId(String userId) {
    UserModel userModel = userRepository.findByUserId(userId);
    return new UserResponseModel(userModel);
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    UserModel userModel = userRepository.findByEmail(email);
    if (userModel == null)
      throw new UsernameNotFoundException(email);
    return new User(userModel.getEmail(), userModel.getPassword(), true, true, true, true, new ArrayList<>());
  }

}