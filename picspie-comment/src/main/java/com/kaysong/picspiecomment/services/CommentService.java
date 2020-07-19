package com.kaysong.picspiecomment.services;

import java.util.UUID;

import com.kaysong.picspiecomment.models.CommentModel;
import com.kaysong.picspiecomment.models.CommentResponseModel;
import com.kaysong.picspiecomment.repositories.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentService {

  @Autowired
  private CommentRepository commentRepository;

  public Iterable<CommentResponseModel> getCommentsByPostId(String postId) {
    Iterable<CommentResponseModel> comments = commentRepository.findByPostId(postId);
    return comments;
  }

  public CommentModel createComment(CommentModel commentModel) {
    commentModel.setCommentId(UUID.randomUUID().toString());
    return commentRepository.save(commentModel);
  }

  @Transactional
  public Integer deleteCommentByCommentId(String commentId) {
    Integer res = commentRepository.deleteByCommentId(commentId);
    return res;
  }
}