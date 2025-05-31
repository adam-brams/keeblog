package com.keeblog.dto;

import com.keeblog.enums.*;
import lombok.Data;

@Data
public class KeyboardBuildResponse {

    private Long id;  // Usually included in response DTOs

    private Long authorId;  // Id of the user who created the build

    private String buildNickname;

    private String keyboardName;

    private Boolean isPlateless;

    private PlateMaterial plateMaterial;

    private Boolean plateHasFlexCuts;

    private PcbThickness pcbThickness;

    private Boolean pcbHasFlexCuts;

    private String switches;

    private LubeType switchLube;

    private SwitchSpringsResponse switchSprings;

    private SwitchFilm switchFilms;

    private String stabilizers;

    private LubeType stabilizerLube;

    private String keycapSet;

    private String artisanKeycaps;
}
