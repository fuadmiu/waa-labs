package edu.miu.lab02.service;

import edu.miu.lab02.domain.dto.response.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAll();

    PostDto findById(long id);

    void deleteById(long id);

    void save(PostDto p);
}
