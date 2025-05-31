package com.keeblog.service;

import com.keeblog.dto.PostRequest;
import com.keeblog.dto.PostResponse;
import com.keeblog.mapper.PostMapper;
import com.keeblog.model.KeyboardBuild;
import com.keeblog.model.Post;
import com.keeblog.model.User;
import com.keeblog.repository.KeyboardBuildRepository;
import com.keeblog.repository.PostRepository;
import com.keeblog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final KeyboardBuildRepository keyboardBuildRepository;

    public PostResponse createPost(PostRequest request, Long userId) {
        User author = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        KeyboardBuild keyboardBuild = keyboardBuildRepository.findById(request.getKeyboardBuildId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Keyboard build not found"));

        Post post = PostMapper.toEntity(request);
        post.setAuthor(author);
        post.setKeyboardBuild(keyboardBuild);

        Post savedPost = postRepository.save(post);
        return PostMapper.toResponse(savedPost);
    }

    public List<PostResponse> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(PostMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<PostResponse> getPostsByUser(Long userId) {
        return postRepository.findAllByAuthorId(userId)
                .stream()
                .map(PostMapper::toResponse)
                .collect(Collectors.toList());
    }
}
