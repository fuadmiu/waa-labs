package edu.miu.lab01.controller;

import edu.miu.lab01.domain.dto.response.PostDto;
import edu.miu.lab01.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/posts")
@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<PostDto> getPosts() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDto getPostById(@PathVariable int id) {
        return postService.findById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody PostDto post) {
        postService.save(post);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        postService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateById(@PathVariable int id, @RequestBody PostDto post) {
        postService.updateById(id, post);
    }
}
