package edu.miu.lab04.repository;

import edu.miu.lab04.domain.Post;
import edu.miu.lab04.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findAll();

    @Query(value = "SELECT u.posts from User u WHERE u.id = :id")
    List<Post> findPosts(long id);

    @Query(value = "SELECT u FROM User u WHERE u.posts.size > 1")
    List<User> findUsersWithMultiplePosts();

    @Query(value = "SELECT u FROM User u WHERE u.posts.size > :postCount")
    List<User> getUsersWithPostsMoreThan(int postCount);
}
