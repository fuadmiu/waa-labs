package edu.miu.lab02.repository;

import edu.miu.lab02.domain.Post;
import edu.miu.lab02.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findAll();

    @Query(value = "SELECT u.posts from User u WHERE u.id = :id")
    List<Post> findPosts(long id);
}
