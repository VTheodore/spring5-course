package com.vezenkov.restmvc.dao;

import com.vezenkov.restmvc.model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PostRepositoryMock implements PostRepository {
    private final AtomicLong nextId = new AtomicLong(0L);
    private final Map<Long, Post> posts = new ConcurrentHashMap<>();

    public PostRepositoryMock() {
        Arrays.stream(new Post[] {
                new Post("New Spring 5", "WebFlux is here ...", "Trayan Iliev"),
                new Post("DI Basics", "There are many ways to DI in Spring ...", "Trayan Iliev"),
                new Post("Reactive Spring", "WebFlux is based on project Ractor  ...", "Trayan Iliev")
        }).forEach(this::createPost);
    }

    @Override
    public List<Post> findAll() {
        return new ArrayList<>(posts.values());
    }

    @Override
    public Post findById(Long id) {
        return this.posts.get(id);
    }

    @Override
    public Post createPost(Post post) {
        post.setId(this.nextId.incrementAndGet());

        return this.posts.put(post.getId(), post);
    }

    @Override
    public Post updatePost(Post post) {
        return null;
    }

    @Override
    public Post deleteById(Long id) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }
}
