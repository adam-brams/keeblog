package com.keeblog.controller;

import com.keeblog.dto.KeyboardBuildRequest;
import com.keeblog.dto.KeyboardBuildResponse;
import com.keeblog.model.KeyboardBuild;
import com.keeblog.security.CurrentUserProvider;
import com.keeblog.service.KeyboardBuildService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/builds")
@RequiredArgsConstructor
public class KeyboardBuildController {

    private final KeyboardBuildService keyboardBuildService;
    private final CurrentUserProvider currentUserProvider;

    @PostMapping
    public ResponseEntity<KeyboardBuildResponse> createBuild(@RequestBody KeyboardBuildRequest request) {
        Long currentUserId = currentUserProvider.getCurrentUser().getId();

        KeyboardBuildResponse response = keyboardBuildService.createBuild(request, currentUserId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<KeyboardBuildResponse>> getAllBuilds() {
        List<KeyboardBuildResponse> builds = keyboardBuildService.getAllBuilds();
        return ResponseEntity.ok(builds);
    }

    @GetMapping("/mine")
    public ResponseEntity<List<KeyboardBuildResponse>> getMyBuilds() {
        Long currentUserId = currentUserProvider.getCurrentUser().getId();

        List<KeyboardBuildResponse> builds = keyboardBuildService.getBuildsByUser(currentUserId);
        return ResponseEntity.ok(builds);
    }
}
