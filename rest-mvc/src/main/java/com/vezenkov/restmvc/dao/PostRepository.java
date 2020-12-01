package com.vezenkov.restmvc.dao;

import com.vezenkov.restmvc.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findAllByKeywordsContaining(Iterable<String> keywords);
}
