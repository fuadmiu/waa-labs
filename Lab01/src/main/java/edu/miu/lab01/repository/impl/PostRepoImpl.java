package edu.miu.lab01.repository.impl;

import edu.miu.lab01.domain.Post;
import edu.miu.lab01.repository.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepo {
    private static List<Post> posts;
    private static int postId = 300;
    static {
        posts = new ArrayList<>();
        Post p1 = new Post(111,"Spring Boot","A Post About Spring Boot","Fuad");
        Post p2 = new Post(112,"React","A Post About React JS Library","Sadia");

        posts.add(p1);
        posts.add(p2);
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post findById(int id) {
        return posts.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteById(int id) {
        Post post = findById(id);
        if (post != null) {
            posts.remove(post);
        }
    }

    @Override
    public void save(Post p) {
        p.setId(postId++);
        posts.add(p);
    }

    @Override
    public void updateById(int id, Post post) {
        Post postToUpdate = findById(id);
        postToUpdate.setTitle(post.getTitle());
        postToUpdate.setContent(post.getContent());
        postToUpdate.setAuthor(post.getAuthor());
    }
}
