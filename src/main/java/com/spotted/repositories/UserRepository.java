package com.spotted.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spotted.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>  {
	
	@Query("select u from User u where u.email = ?1")
	User findUserByEmail(String email);
	
	@Query("select u from User u where u.nickname like ?1%")
	List<User> findUserByNickname(String nickname);

}
