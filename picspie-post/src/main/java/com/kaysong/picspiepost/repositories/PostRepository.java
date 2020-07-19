package com.kaysong.picspiepost.repositories;

import com.kaysong.picspiepost.models.PostModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<PostModel, Long> {

  Integer deleteByPostId(String postId);

  Iterable<PostModel> findAll();

  PostModel findByPostId(String postId);

}