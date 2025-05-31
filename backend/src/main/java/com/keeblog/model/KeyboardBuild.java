package com.keeblog.model;

import com.keeblog.enums.LubeType;
import com.keeblog.enums.PcbThickness;
import com.keeblog.enums.PlateMaterial;
import com.keeblog.enums.SwitchFilm;
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
    private Boolean isPlateless;

    @Enumerated(EnumType.STRING)
    private PlateMaterial plateMaterial;

    private Boolean plateHasFlexCuts;

    @Enumerated(EnumType.STRING)
    private PcbThickness pcbThickness;

    private Boolean pcbHasFlexCuts;

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
