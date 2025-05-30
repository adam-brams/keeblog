package com.keeblog.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "keyboard_builds")
public class KeyboardBuild {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private PlateMaterial plateMaterial;

    private boolean plateHasFlexCuts;

    @Enumerated(EnumType.STRING)
    private PcbThickness pcbThickness;

    private boolean pcbHasFlexCuts;

    private String switches;

    @Enumerated(EnumType.STRING)
    private LubeType switchLube;

    @Embedded
    private SwitchSpring switchSprings;

    @Enumerated(EnumType.STRING)
    private LubeType SpringLube;

    @Enumerated(EnumType.STRING)
    private SwitchFilm switchFilms;

    private String stabilizers;

    @Enumerated(EnumType.STRING)
    private LubeType stabilizerLube;

    private String keycapSet;

    private String artisanKeycaps;
}
