package com.spotted.repositories;

import com.spotted.models.Post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>  {
	
	@Query("select p from Post p where p.nickname = ?1")
	List<Post> postsByNickname(String nickname);
	
	@Query("select p from Post p where p.id = ?1")
	Post postsById(Long id);

}
