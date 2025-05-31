package com.keeblog.dto;

import com.keeblog.enums.LubeType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SwitchSpringsRequest {
    @NotNull
    private String brand;

    @NotNull
    private Integer weight;

    @NotNull
    private Integer length;

    @NotNull
    private LubeType springLube;
}
