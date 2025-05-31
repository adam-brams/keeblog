package com.keeblog.dto;

import lombok.Data;

@Data
public class PostImageRequest {
    private String imageUrl;
    private int imageOrder;
}
