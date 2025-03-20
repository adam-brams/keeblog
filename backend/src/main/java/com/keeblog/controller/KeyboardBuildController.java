package com.keeblog.controller;

import com.keeblog.model.KeyboardBuild;
import com.keeblog.service.KeyboardBuildService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/builds")
public class KeyboardBuildController {
    private final KeyboardBuildService service;

    public KeyboardBuildController(KeyboardBuildService service) {
        this.service = service;
    }

    @GetMapping
    public List<KeyboardBuild> getAllBuilds() {
        return service.getAllBuilds();
    }

    @PostMapping
    public KeyboardBuild createBuild(@RequestBody KeyboardBuild build) {
        return service.createBuild(build);
    }
}
