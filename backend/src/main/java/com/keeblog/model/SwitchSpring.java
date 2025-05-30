package com.keeblog.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class SwitchSpring {
    @Column(name = "spring_brand")
    private String brand;

    @Column(name = "spring_weight")
    private int weight; // grams

    @Column(name = "spring_length")
    private float length; // millimeters

}
