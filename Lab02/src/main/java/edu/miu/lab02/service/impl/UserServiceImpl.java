package edu.miu.lab02.service.impl;

import edu.miu.lab02.domain.User;
import edu.miu.lab02.domain.dto.response.PostDto;
import edu.miu.lab02.domain.dto.response.UserDto;
import edu.miu.lab02.repository.UserRepo;
import edu.miu.lab02.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDto> findAll() {
        return userRepo.findAll().stream()
                .map(p -> modelMapper.map(p, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(long id) {
        return modelMapper.map(userRepo.findById(id), UserDto.class);
    }

    @Override
    public List<PostDto> findUserPosts(long id) {
        var posts = userRepo.findPosts(id);
        return posts.stream()
                .map(p -> modelMapper.map(p, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void save(UserDto u) {
        User user = modelMapper.map(u, User.class);
        userRepo.save(user);
    }
}
