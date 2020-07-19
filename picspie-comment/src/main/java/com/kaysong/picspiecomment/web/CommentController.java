package com.kaysong.picspiecomment.web;

import javax.validation.Valid;

import com.kaysong.picspiecomment.models.CommentModel;
import com.kaysong.picspiecomment.models.CommentResponseModel;
import com.kaysong.picspiecomment.services.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class CommentController {

  @Autowired
  private CommentService commentService;

  @GetMapping("/status")
  public String getStatus() {
    return "Comment Server is Working";
  }

  @GetMapping("/{postId}")
  public ResponseEntity<Iterable<CommentResponseModel>> getCommentsByPostId(@PathVariable String postId) {
    Iterable<CommentResponseModel> comments = commentService.getCommentsByPostId(postId);
    return new ResponseEntity<Iterable<CommentResponseModel>>(comments, HttpStatus.OK);
  }

  @PostMapping("")
  public ResponseEntity<CommentModel> createComment(@Valid @RequestBody CommentModel commentModel) {
    CommentModel comment = commentService.createComment(commentModel);
    return new ResponseEntity<CommentModel>(comment, HttpStatus.CREATED);
  }

  @DeleteMapping("/{commentId}")
  public ResponseEntity<Integer> deleteCommentByCommentId(@PathVariable String commentId) {
    Integer res = commentService.deleteCommentByCommentId(commentId);
    return new ResponseEntity<Integer>(res, HttpStatus.ACCEPTED);
  }
}