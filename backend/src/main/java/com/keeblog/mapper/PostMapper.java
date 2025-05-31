package com.keeblog.mapper;

import com.keeblog.dto.*;
import com.keeblog.model.Post;
import com.keeblog.model.PostImage;
import com.keeblog.model.User;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PostMapper {

    public static PostResponse toResponse(Post post) {
        if (post == null) return null;

        PostResponse response = new PostResponse();
        response.setId(post.getId());
        response.setTitle(post.getTitle());
        response.setVideoUrl(post.getVideoUrl());

        response.setKeyboardBuild(KeyboardBuildMapper.toResponse(post.getKeyboardBuild()));
        response.setAuthor(toUserSummary(post.getAuthor()));

        // Map and sort images
        List<PostImageResponse> imageResponses = post.getImages().stream()
                .sorted(Comparator.comparingInt(PostImage::getImageOrder))
                .map(image -> {
                    PostImageResponse dto = new PostImageResponse();
                    dto.setImageUrl(image.getImageUrl());
                    dto.setImageOrder(image.getImageOrder());
                    return dto;
                })
                .collect(Collectors.toList());

        response.setImages(imageResponses);

        return response;
    }

    public static Post toEntity(PostRequest request) {
        if (request == null) return null;

        Post post = new Post();
        post.setTitle(request.getTitle());
        post.setVideoUrl(request.getVideoUrl());

        if (request.getImages() != null) {
            List<PostImage> images = request.getImages().stream()
                    .map(dto -> {
                        PostImage image = new PostImage();
                        image.setImageUrl(dto.getImageUrl());
                        image.setImageOrder(dto.getImageOrder());
                        image.setPost(post);
                        return image;
                    })
                    .collect(Collectors.toList());

            post.setImages(images);
        }

        return post;
    }

    private static UserSummary toUserSummary(User user) {
        if (user == null) return null;

        UserSummary summary = new UserSummary();
        summary.setId(user.getId());
        summary.setUsername(user.getUsername());

        return summary;
    }
}
