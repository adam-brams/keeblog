package com.keeblog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class PostRequest {

    @NotBlank
    private String title;

    @NotNull
    private Long keyboardBuildId;

    private String videoUrl;

    private List<PostImageRequest> images;

}
