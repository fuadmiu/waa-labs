package edu.miu.lab04.repository;

import edu.miu.lab04.domain.Comment;
import edu.miu.lab04.domain.Post;
import edu.miu.lab04.domain.dto.response.PostDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends CrudRepository<Post, Long> {
    List<Post> findAll();
    Post findById(long id);

    @Query(value = "select p.comments from Post p where p.id = :id")
    List<Comment> findComments(long id);

    List<Post> findByTitleLike(String title);
}
