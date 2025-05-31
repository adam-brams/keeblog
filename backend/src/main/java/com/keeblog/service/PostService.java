package com.keeblog.service;

import com.keeblog.model.Post;
import com.keeblog.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> getAllPosts() {
        return repository.findAll();
    }

    public Post createPost(Post post) {
        return repository.save(post);
    }
}
