package edu.miu.lab01.service.impl;

import edu.miu.lab01.domain.Post;
import edu.miu.lab01.domain.dto.response.PostDto;
import edu.miu.lab01.repository.PostRepo;
import edu.miu.lab01.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PostDto> findAll() {
        return postRepo.findAll().stream()
                .map(p -> modelMapper.map(p, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto findById(int id) {
        return modelMapper.map(postRepo.findById(id), PostDto.class);
    }

    @Override
    public void deleteById(int id) {
        postRepo.deleteById(id);
    }

    @Override
    public void save(PostDto p) {
        Post post = modelMapper.map(p, Post.class);
        postRepo.save(post);
    }

    @Override
    public void updateById(int id, PostDto p) {
        Post post = modelMapper.map(p, Post.class);
        postRepo.updateById(id, post);
    }

}
