package com.keeblog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

@Getter
@Setter
@Entity
@Table(name = "post_images")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PostImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    @JsonBackReference
    private Post post;

    @Column(nullable = false)
    private String imageUrl;

    private Integer imageOrder;
}