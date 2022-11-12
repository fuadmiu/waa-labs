package edu.miu.lab05.controller;

import edu.miu.lab05.aspect.annotation.ExecutionTime;
import edu.miu.lab05.aspect.annotation.Log;
import edu.miu.lab05.domain.dto.response.PostDto;
import edu.miu.lab05.domain.dto.response.UserDto;
import edu.miu.lab05.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Log
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getUsers() {
        return userService.findAll();
    }

    @ExecutionTime
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUserById(@PathVariable long id) {
        return userService.findById(id);
    }

    @GetMapping("/{id}/posts")
    @ResponseStatus(HttpStatus.OK)
    public List<PostDto> getUserPosts(@PathVariable long id) {
        return userService.findUserPosts(id);
    }

    @GetMapping("/multiposts")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getUsersWithMultiplePosts() {
        return userService.findUsersWithMultiplePosts();
    }

    @GetMapping("/post-more-than/{count}")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getUsersWithPostsMoreThan(@PathVariable int count) {
        return userService.getUsersWithPostsMoreThan(count);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody UserDto user) {
        userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        userService.deleteById(id);
    }
}
