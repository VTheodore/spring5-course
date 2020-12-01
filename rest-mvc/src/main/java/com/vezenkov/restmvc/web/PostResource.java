package com.vezenkov.restmvc.web;

import com.vezenkov.restmvc.exception.InvalidEntityDataException;
import com.vezenkov.restmvc.model.Post;
import com.vezenkov.restmvc.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/posts")
public class PostResource {

    private final PostService postService;

    @Autowired
    public PostResource(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts(@RequestParam(name = "keywords", required = false) String keywordStr) {
        if (keywordStr != null && !keywordStr.trim().isEmpty()) {
            Set<String> keywords = Set.of(keywordStr.trim().split(",\\s*"));
            return this.postService.getAllPostsByKeywords(keywords);
        }

        return this.postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable("id") String id) {
        return this.postService.getPostById(id);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post created = this.postService.addPost(post);

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
        if (!id.equals(post.getId())) {
            throw new InvalidEntityDataException(String.format("URL ID:%s differs from body entity ID:%s", id, post.getId()));
        }

        return this.postService.updatePost(post);
    }

    @DeleteMapping("/{id}")
    public Post deletePost(@PathVariable("id") String id) {
        return this.postService.deletePost(id);
    }
}
