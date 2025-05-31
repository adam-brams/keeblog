package com.keeblog.dto;

import lombok.Data;
import java.util.List;

@Data
public class PostResponse {

    private Long id;

    private String title;

    private String videoUrl;

    private KeyboardBuildResponse keyboardBuild;

    private UserSummary author;

    private List<PostImageResponse> images;
}
