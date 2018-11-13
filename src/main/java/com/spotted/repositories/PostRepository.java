package com.spotted.repositories;

import com.spotted.models.Post;
import com.spotted.enums.PostTypes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>  {
	

	@Query("select p from Post p where p.parent.email = ?1")
	List<Post> postsByEmail(String email);
	
	@Query("select p from Post p where p.id = ?1")
	Post postsById(Long id);
	
	@Query("select p from Post p where p.type = ?1")
	List<Post> postsByType(PostTypes postType);

}
