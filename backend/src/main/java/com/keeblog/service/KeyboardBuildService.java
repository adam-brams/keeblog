package com.keeblog.service;

import com.keeblog.model.KeyboardBuild;
import com.keeblog.repository.KeyboardBuildRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeyboardBuildService {
    private final KeyboardBuildRepository repository;

    public KeyboardBuildService(KeyboardBuildRepository repository) {
        this.repository = repository;
    }

    public List<KeyboardBuild> getAllBuilds() {
        return repository.findAll();
    }

    public KeyboardBuild createBuild(KeyboardBuild build) {
        return repository.save(build);
    }
}
