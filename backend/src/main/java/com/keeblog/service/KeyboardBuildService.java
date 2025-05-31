package com.keeblog.service;

import com.keeblog.dto.KeyboardBuildRequest;
import com.keeblog.dto.KeyboardBuildResponse;
import com.keeblog.dto.SwitchSpringsRequest;
import com.keeblog.dto.SwitchSpringsResponse;
import com.keeblog.enums.*;
import com.keeblog.mapper.KeyboardBuildMapper;
import com.keeblog.model.KeyboardBuild;
import com.keeblog.model.SwitchSpring;
import com.keeblog.model.User;
import com.keeblog.repository.KeyboardBuildRepository;
import com.keeblog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KeyboardBuildService {

    private final KeyboardBuildRepository buildRepository;
    private final UserRepository userRepository;

    public KeyboardBuildResponse createBuild(KeyboardBuildRequest request, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        KeyboardBuild build = KeyboardBuildMapper.toEntity(request);
        build.setAuthor(user);

        KeyboardBuild savedBuild = buildRepository.save(build);
        return KeyboardBuildMapper.toResponse(savedBuild);
    }

    public List<KeyboardBuildResponse> getAllBuilds() {
        return buildRepository.findAll()
                .stream()
                .map(KeyboardBuildMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<KeyboardBuildResponse> getBuildsByUser(Long userId) {
        return buildRepository.findAllByAuthorId(userId)
                .stream()
                .map(KeyboardBuildMapper::toResponse)
                .collect(Collectors.toList());
    }

}
