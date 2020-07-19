package com.kaysong.picspiepost.services;

import java.util.UUID;

import com.kaysong.picspiepost.models.PostModel;
import com.kaysong.picspiepost.repositories.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {

  @Autowired
  private PostRepository postRepository;

  public Iterable<PostModel> findAll() {
    return postRepository.findAll();
  }

  public PostModel findByPostId(String postId) {
    return postRepository.findByPostId(postId);
  }

  @Transactional
  public Integer deleteByPostId(String postId) {
    return postRepository.deleteByPostId(postId);
  }

  public PostModel createPost(PostModel postModel) {
    postModel.setPostId(UUID.randomUUID().toString());
    return postRepository.save(postModel);
  }

}