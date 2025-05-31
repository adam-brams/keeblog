package com.keeblog.dto;

import com.keeblog.enums.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class KeyboardBuildRequest {

    @NotBlank
    private String buildNickname;

    @NotBlank
    private String keyboardName;

    @NotNull
    private Boolean isPlateless;

    @NotNull
    private PlateMaterial plateMaterial;

    @NotNull
    private Boolean plateHasFlexCuts;

    @NotNull
    private PcbThickness pcbThickness;

    @NotNull
    private Boolean pcbHasFlexCuts;

    @NotBlank
    private String switches;

    @NotNull
    private LubeType switchLube;

    @NotNull
    private SwitchSpringsRequest switchSprings;

    @NotNull
    private SwitchFilm switchFilms;

    @NotBlank
    private String stabilizers;

    @NotNull
    private LubeType stabilizerLube;

    @NotBlank
    private String keycapSet;

    private String artisanKeycaps;

}
