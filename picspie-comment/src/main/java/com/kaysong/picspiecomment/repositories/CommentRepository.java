package com.kaysong.picspiecomment.repositories;

import com.kaysong.picspiecomment.models.CommentModel;
import com.kaysong.picspiecomment.models.CommentResponseModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<CommentModel, Long> {

  Iterable<CommentResponseModel> findByPostId(String postId);

  Integer deleteByCommentId(String commentId);
}