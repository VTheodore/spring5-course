package com.vezenkov.restmvc.web;

import com.vezenkov.restmvc.dao.PostRepository;
import com.vezenkov.restmvc.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostResource {

    private final PostRepository repository;

    @Autowired
    public PostResource(PostRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return this.repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post post) {
        return this.repository.createPost(post);
    }
}
