package com.keeblog.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "keyboard_builds")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class KeyboardBuild {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    private String buildNickname;

    @Column(nullable = false)
    private String keyboardName;

    @Column(nullable = false)
    private boolean isPlateless;

    @Enumerated(EnumType.STRING)
    private PlateMaterial plateMaterial;

    private boolean plateHasFlexCuts;

    @Enumerated(EnumType.STRING)
    private PcbThickness pcbThickness;

    private boolean pcbHasFlexCuts;

    @Column(nullable = false)
    private String switches;

    @Enumerated(EnumType.STRING)
    private LubeType switchLube;

    @Embedded
    private SwitchSpring switchSprings;

    @Enumerated(EnumType.STRING)
    private SwitchFilm switchFilms;

    private String stabilizers;

    @Enumerated(EnumType.STRING)
    private LubeType stabilizerLube;

    private String keycapSet;

    private String artisanKeycaps;
}
