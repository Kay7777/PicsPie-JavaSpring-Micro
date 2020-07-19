package com.kaysong.picspiepost.web;

import javax.validation.Valid;

import com.kaysong.picspiepost.models.PostModel;
import com.kaysong.picspiepost.services.PostService;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

  @Autowired
  private PostService postService;

  @GetMapping("/status")
  public String getStatus() {
    return "posts server working";
  }

  @GetMapping("")
  public ResponseEntity<Iterable<PostModel>> getPosts() {
    Iterable<PostModel> posts = postService.findAll();
    return new ResponseEntity<Iterable<PostModel>>(posts, HttpStatus.OK);
  }

  @PostMapping("")
  public ResponseEntity<PostModel> createPost(@Valid @RequestBody PostModel postModel) {
    PostModel postModel2 = postService.createPost(postModel);
    return new ResponseEntity<PostModel>(postModel2, HttpStatus.CREATED);
  }

  @GetMapping("/{postId}")
  public ResponseEntity<PostModel> findByPostId(@PathVariable String postId) {
    PostModel postModel = postService.findByPostId(postId);
    return new ResponseEntity<PostModel>(postModel, HttpStatus.OK);
  }

  @DeleteMapping("/{postId}")
  public ResponseEntity<Integer> deleteByPostId(@PathVariable String postId) {
    Integer res = postService.deleteByPostId(postId);
    return new ResponseEntity<Integer>(res, HttpStatus.ACCEPTED);
  }
}