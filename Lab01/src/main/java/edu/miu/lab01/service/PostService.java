package edu.miu.lab01.service;

import edu.miu.lab01.domain.dto.response.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAll();

    PostDto findById(int id);

    void deleteById(int id);

    void save(PostDto p);

    void updateById(int id, PostDto p);
}
