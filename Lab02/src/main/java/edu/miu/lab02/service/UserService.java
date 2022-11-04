package edu.miu.lab02.service;

import edu.miu.lab02.domain.dto.response.PostDto;
import edu.miu.lab02.domain.dto.response.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findById(long id);

    List<PostDto> findUserPosts(long id);

    List<UserDto> findUsersWithMultiplePosts();

    void deleteById(long id);

    void save(UserDto u);
}
