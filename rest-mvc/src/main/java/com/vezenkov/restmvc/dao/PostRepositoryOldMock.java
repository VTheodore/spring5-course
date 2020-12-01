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
public class PostRepositoryOldMock implements PostRepositoryOld {
    private final AtomicLong nextId = new AtomicLong(0L);
    private final Map<String, Post> posts = new ConcurrentHashMap<>();

    public PostRepositoryOldMock() {
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
    public Post findById(String id) {
        return this.posts.get(id);
    }

    @Override
    public Post createPost(Post post) {
        post.setId(String.format("%024d", this.nextId.incrementAndGet()));
        this.posts.put(post.getId(), post);
        return post;
    }

    @Override
    public Post updatePost(Post post) {
        Post old = this.posts.replace(post.getId(), post);

        if (old == null) return null;
        return post;
    }

    @Override
    public Post deleteById(String id) {
        return this.posts.remove(id);
    }

    @Override
    public long count() {
        return posts.size();
    }
}
