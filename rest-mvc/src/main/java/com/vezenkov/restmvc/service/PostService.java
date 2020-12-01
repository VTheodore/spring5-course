package com.vezenkov.restmvc.service;

import com.vezenkov.restmvc.model.Post;

import java.util.List;
import java.util.Set;

public interface PostService {
    List<Post> getAllPosts();

    List<Post> getAllPostsByKeywords(Set<String> keywords);

    Post getPostById(String id);

    Post addPost(Post post);

    Post updatePost(Post post);

    Post deletePost(String id);

    long getCount();
}
