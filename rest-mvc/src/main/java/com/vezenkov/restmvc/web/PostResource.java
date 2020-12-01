package com.vezenkov.restmvc.web;

import com.vezenkov.restmvc.dao.PostRepository;
import com.vezenkov.restmvc.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

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

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable("id") String id) {
        return this.repository.findById(id);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post created = this.repository.createPost(post);

        return ResponseEntity.created(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .pathSegment("{id}")
                        .buildAndExpand(created.getId())
                        .toUri()
        ).body(created);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable("id") String id, @RequestBody Post post) {
        return this.repository.updatePost(post);
    }

    @DeleteMapping("/{id}")
    public Post deletePost(@PathVariable("id") String id) {
        return this.repository.deleteById(id);
    }
}
