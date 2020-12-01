package com.vezenkov.restmvc.dao;

import com.vezenkov.restmvc.model.Post;

import java.util.List;

public interface PostRepository {
    List<Post> findAll();

    Post findById(String id);

    Post createPost(Post post);

    Post updatePost(Post post);

    Post deleteById(String id);

    long count();
}
