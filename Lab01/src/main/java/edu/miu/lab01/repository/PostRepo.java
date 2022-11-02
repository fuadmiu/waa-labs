package edu.miu.lab01.repository;

import edu.miu.lab01.domain.Post;

import java.util.List;

public interface PostRepo {
    List<Post> findAll();

    Post findById(int id);

    void deleteById(int id);

    void save(Post p);

    void updateById(int id, Post post);
}
