package com.kaysong.picspieauth.repositories;

import com.kaysong.picspieauth.models.UserModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {

  UserModel findByEmail(String email);

  UserModel findByUserId(String userId);

}