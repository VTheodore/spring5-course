package course.spring.myblogsapp.service;

import course.spring.myblogsapp.dao.PostRepository;
import course.spring.myblogsapp.entity.Post;
import course.spring.myblogsapp.exception.NonExistingEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@Validated
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAllPost() {
        return this.postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        return this.postRepository
                .findById(id)
                .orElseThrow(() -> new NonExistingEntityException(String.format("Post with ID=%d does not exist.", id)));
    }

    @Override
    @Transactional
    public Post addPost(@Valid Post post) {
        post.setId(null);
        return this.postRepository.save(post);
    }

    @Override
    @Transactional
    public Post updatePost(Post post) {
        Post old = this.getPostById(post.getId());
        post.setModified(LocalDateTime.now());
        return this.postRepository.save(post);
    }

    @Override
    @Transactional
    public Post deletePost(Long id) {
        Post old = this.getPostById(id);
        this.postRepository.delete(old);
        return old;
    }

    @Override
    public long getPostsCount() {
        return this.postRepository.count();
    }
}
