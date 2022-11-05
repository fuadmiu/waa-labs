package edu.miu.lab03.service.impl;

import edu.miu.lab03.domain.Comment;
import edu.miu.lab03.domain.Post;
import edu.miu.lab03.domain.dto.response.CommentDto;
import edu.miu.lab03.domain.dto.response.PostDto;
import edu.miu.lab03.repository.PostRepo;
import edu.miu.lab03.service.PostService;
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
    public PostDto findById(long id) {
        return modelMapper.map(postRepo.findById(id), PostDto.class);
    }

    @Override
    public void deleteById(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void save(PostDto p) {
        Post post = modelMapper.map(p, Post.class);
        postRepo.save(post);
    }

    @Override
    public void addComment(long postId, CommentDto comment) {
        Post post = postRepo.findById(postId);
        if (post != null) {
            post.getComments().add(modelMapper.map(comment, Comment.class));
            postRepo.save(post);
        }
    }

    @Override
    public List<CommentDto> getComments(long postId) {
        List<Comment> comments = postRepo.findComments(postId);
        return comments.stream()
                .map(c -> modelMapper.map(c, CommentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> findByTitleLike(String title) {
        var posts = postRepo.findByTitleLike(title);
        return posts.stream()
                .map(p -> modelMapper.map(p, PostDto.class))
                .collect(Collectors.toList());
    }
}
