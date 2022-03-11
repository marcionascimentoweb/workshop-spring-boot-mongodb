package com.marcionascimento.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.marcionascimento.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	@Query("{'title': {$tegex: ?0, $options: 'i'} }")
	List<Post> searchTitle(String text);
	
	//Consulta pelo titulo
	List<Post> findByTitleContainingIgnoreCase(String text);
}
