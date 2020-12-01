package com.vezenkov.restmvc.service.impl;

import com.vezenkov.restmvc.dao.PostRepository;
import com.vezenkov.restmvc.exception.NonExistingEntityException;
import com.vezenkov.restmvc.model.Post;
import com.vezenkov.restmvc.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAllPosts() {
        return this.postRepository.findAll();
    }

    @Override
    public List<Post> getAllPostsByKeywords(Set<String> keywords) {
        return this.postRepository.findAllByKeywordsContaining(keywords);
    }

    @Override
    public Post getPostById(String id) {
        return this.postRepository.findById(id)
                .orElseThrow(() -> new NonExistingEntityException(String.format("Post with ID:%s does not exist.", id)));
    }

    @Override
    public Post addPost(Post post) {
        post.setId(null);
        return this.postRepository.insert(post);
    }

    @Override
    public Post updatePost(Post post) {
        this.getPostById(post.getId());
        post.setModified(LocalDateTime.now());

        return this.postRepository.save(post);
    }

    @Override
    public Post deletePost(String id) {
        Post removed = this.getPostById(id);
        this.postRepository.delete(removed);
        return removed;
    }

    @Override
    public long getCount() {
        return this.postRepository.count();
    }
}
