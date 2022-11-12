package edu.miu.lab05.service;

import edu.miu.lab05.domain.dto.response.CommentDto;
import edu.miu.lab05.domain.dto.response.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAll();

    PostDto findById(long id);

    void deleteById(long id);

    void save(PostDto p);

    void addComment(long postId, CommentDto comment);

    List<CommentDto> getComments(long postId);

    List<PostDto> findByTitleLike(String title);
}
