package com.keeblog.controller;

import com.keeblog.dto.PostRequest;
import com.keeblog.dto.PostResponse;
import com.keeblog.security.CurrentUserProvider;
import com.keeblog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final CurrentUserProvider currentUserProvider;

    @PostMapping
    public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest request) {
        Long userId = currentUserProvider.getCurrentUser().getId();
        PostResponse response = postService.createPost(request, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/mine")
    public ResponseEntity<List<PostResponse>> getMyPosts() {
        Long userId = currentUserProvider.getCurrentUser().getId();
        return ResponseEntity.ok(postService.getPostsByUser(userId));
    }
}
