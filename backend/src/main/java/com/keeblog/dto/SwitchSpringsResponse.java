package com.keeblog.dto;

import com.keeblog.enums.LubeType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SwitchSpringsResponse {
    private String brand;
    private Integer weight;
    private float length;
    private LubeType springLube;
}
