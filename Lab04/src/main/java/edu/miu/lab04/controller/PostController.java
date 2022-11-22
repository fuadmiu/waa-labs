package edu.miu.lab04.controller;

import edu.miu.lab04.domain.dto.response.CommentDto;
import edu.miu.lab04.domain.dto.response.PostDto;
import edu.miu.lab04.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/posts")
@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<PostDto> getPosts() {
        return postService.findAll();
    }

    @GetMapping("/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<PostDto> getPostsMatchingTitle(@PathVariable String title) {
        return postService.findByTitleLike(title);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDto getPostById(@PathVariable long id) {
        return postService.findById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody PostDto post) {
        postService.save(post);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@PathVariable long id, @RequestBody PostDto post) {
        postService.update(id, post);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        postService.deleteById(id);
    }


    // Endpoints for Comments

    @GetMapping("/{postId}/comments")
    public List<CommentDto> getComments(@PathVariable long postId) {
        return postService.getComments(postId);
    }

    @PostMapping("/{postId}/comments")
    public void addComment(@PathVariable long postId, @RequestBody CommentDto comment) {
        postService.addComment(postId, comment);
    }

}
